def call(body) {
        def pipelineParams = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    def name = getValueOrDefault("${pipelineParams.name}","n")
     def application = getValueOrDefault("${pipelineParams.application}","n")
    // def notifyEmail = "${pipelineParams.notifyEmail}"
    pipeline{
        agent any
        stages{
            stage('Hello From Inside'){
                steps{
                    script{
                        echo "Hello World From Shared Library ${application}"
                        if(config.name == null){
                            echo "Value Not Provided"
                        }else{
                            echo "My Name is ${name} and age is ${config.age}"         
                        }
                        callingOtherMethod(age: config.age)
                    }
                }
            }
        }
    }
}
