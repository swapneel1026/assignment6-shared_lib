def call(cfg) {

    withCredentials([
        sshUserPrivateKey(
            credentialsId: 'ansible-key',
            keyFileVariable: 'SSH_KEY'
        )
    ]) {

        sh """
            ansible-playbook \
            -i ${cfg.ANSIBLE.INVENTORY} \
            ${cfg.ANSIBLE.PLAYBOOK} \
            --private-key \$SSH_KEY
        """
    }
}