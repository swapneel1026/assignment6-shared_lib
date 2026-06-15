def call(cfg) {

    sh """
        ansible-playbook ${cfg.PLAYBOOK}
    """

}