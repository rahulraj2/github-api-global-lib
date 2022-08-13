def call(application, Map config = [:]) {
    echo "Hello World From Shared Library ${application}"
    pipeline{
        agent any
        stages{
            stage('Hello From Inside'){
                steps{
                    script{
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
