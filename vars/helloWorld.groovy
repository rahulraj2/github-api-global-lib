def call(Map config = [:]) {
    echo "Hello World From Shared Library"
    pipeline{
        agent any
        stages{
            stage('Hello From Inside'){
                echo "${config.name}"
            }
        }
    }
}
