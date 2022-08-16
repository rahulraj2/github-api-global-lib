def call(Map config = [:]) {
    bat "docker login -u ${DOCKER_CRED_USR} --password-stdin ${DOCKER_CRED_PSW}"
    echo "${config.age}"
    if(config.age == null){
        echo "Value Not Passed !! Please Pass the value"
    }else if(config.age > 20) {
        echo "You are adult"
    }else{
        echo "Not Authorize"
    }
}