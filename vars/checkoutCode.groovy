def call(cfg) {

```
echo "Checking out ${cfg.GIT.URL}"
echo "Branch ${cfg.GIT.BRANCH}"

checkout([
    $class: 'GitSCM',
    branches: [[name: "*/${cfg.GIT.BRANCH}"]],
    userRemoteConfigs: [[url: cfg.GIT.URL]]
])
```

}
