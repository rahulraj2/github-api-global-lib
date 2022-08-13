def call(Map config = [:]) {
    echo "${config.age}"
    if("${config.age}" == null){
        echo "Value Not Passed !! Please Pass the value"
    }else{
        echo "You are adult"
    }
}