def call(Map config) {
    def a, b , c
    pipeline{
        agent any
        environment {
            DOCKER_CRED = credentials('dockercred')
            BUILD_EXECUTED_BY = "Rahul"
            SOME_NUMBER = callingOtherMethod(age: config.age)
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
                        println SOME_NUMBER
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
