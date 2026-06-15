def call(cfg) {

    git(
        branch: cfg.BRANCH,
        url: cfg.URL
    )

}