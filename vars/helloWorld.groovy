def call(Map config) {
    def a, b , c
    pipeline{
        agent any
        environment {
            server_username = credentials('name')
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
                        echo "${server_username}"
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
