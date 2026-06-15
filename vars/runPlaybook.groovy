def call(cfg) {

    echo "PLAYBOOK = ${cfg.ANSIBLE.PLAYBOOK}"
    echo "INVENTORY = ${cfg.ANSIBLE.INVENTORY}"

    sh """
        ansible-playbook -i ${cfg.ANSIBLE.INVENTORY} ${cfg.ANSIBLE.PLAYBOOK}
    """
}