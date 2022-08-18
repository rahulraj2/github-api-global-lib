def call(Map config) {
    def a, b , c
    pipeline{
        agent any
        environment {
            DOCKER_CRED = credentials('dockercred')
            BUILD_EXECUTED_BY = "Rahul"
            GIT_URL = "${GIT_URL}"
            GIT_COMMIT = "${GIT_COMMIT}".substring(0,7)
            BUILD_DISPLAY_NAME = "${BUILD_NUMBER}"+"-${GIT_COMMIT}-"+"${BRANCH_NAME}"
        }
        stages{
            stage('Hello From Inside'){
                steps{
                    script{
                        a = 10 
                        b="20"
                        echo "${a} ${b}"
                        println GIT_COMMIT
                        println BRANCH_NAME
                        println BUILD_EXECUTED_BY
                        println env.BUILD_EXECUTED_BY
                        currentBuild.displayName = BUILD_DISPLAY_NAME
                        
                        echo "Hello World From Shared Library ${config.application}"
                        if(config.name == null){
                            echo "Value Not Provided"
                        }else{
                            echo "My Name is ${config.name} and age is ${config.age}"         
                        }
                        callingOtherMethod(age: config.age)
                    }
                }
            }
        }
    }
}
