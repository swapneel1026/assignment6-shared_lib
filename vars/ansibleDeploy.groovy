def call() {

    def config = loadConfig()

    pipeline {
        agent any

        stages {

            stage('Clone Repository') {
                steps {
                    script {
                        checkoutCode(config.GIT)
                    }
                }
            }

            stage('User Approval') {
                when {
                    expression {
                        return config.KEEP_APPROVAL_STAGE
                    }
                }
                steps {
                    script {
                        approvalGate('Approve Ansible Deployment?')
                    }
                }
            }

            stage('Playbook Execution') {
                steps {
                    script {
                        runPlaybook(config.ANSIBLE)
                    }
                }
            }
        }

        post {

            success {
                script {
                    notifySlack(
                        config.SLACK_CHANNEL_NAME,
                        ":white_check_mark: ${config.ACTION_MESSAGE}"
                    )
                }
            }

            failure {
                script {
                    notifySlack(
                        config.SLACK_CHANNEL_NAME,
                        ":x: Assignment 6 Deployment Failed"
                    )
                }
            }
        }
    }
}