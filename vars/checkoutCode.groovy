def call(cfg) {

    git(
        branch: cfg.BRANCH,
        credentialsId: cfg.CREDENTIALS_ID,
        url: cfg.URL
    )

}