def call(Map config = [:]) {
    echo "${config.age}"
    if(config.age > 18){
        echo "You are adult"
    }else{
        echo "Value Not Passed !! Please Pass the value"
    }
}