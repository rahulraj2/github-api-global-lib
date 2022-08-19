def call(Map config = [:]) {
    echo "${config}".size()
    bat "docker login -u ${DOCKER_CRED_USR} -p ${DOCKER_CRED_PSW}"
    echo "${env.BUILD_EXECUTED_BY}"
    echo "${config.age}"
    if(NAMESPACE.contains(config.ENV_NAMESPACE)){
        echo "${config.ENV_NAMESPACE} comes under array"
    }else{
        echo "Please get your namespace added from Inside method"
    }
    if(config.age == null){
        echo "Value Not Passed !! Please Pass the value"
    }else if(config.age > 20) {
        echo "You are adult"
    }else{
        echo "Not Authorize"
    }
    return 5
}