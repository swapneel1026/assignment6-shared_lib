def call(cfg) {

```
echo "Checking out ${cfg.URL}"
echo "Branch ${cfg.BRANCH}"

checkout([
    $class: 'GitSCM',
    branches: [[name: "*/${cfg.BRANCH}"]],
    userRemoteConfigs: [[url: cfg.URL]]
])
```

}
