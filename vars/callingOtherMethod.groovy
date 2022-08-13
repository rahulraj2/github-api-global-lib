def call(Map config = [:]) {
    echo "${config.age}"
    if(config.age == null){
        echo "Value Not Passed !! Please Pass the value"
    }else if(config.age > 20) {
        echo "You are adult"
    }else{
        echo "Not Authorize"
    }
}