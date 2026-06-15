def call(cfg) {

    git(
        url: cfg.GIT.URL ,
       branch: cfg.GIT.BRANCH
    )

}