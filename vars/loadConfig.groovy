def call() {
    return readYaml(
        text: libraryResource('ansible/config.yml')
    )
}