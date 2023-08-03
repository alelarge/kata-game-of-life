fun main() {
    for (i in 1..100) {
        val number = i
        val a = number%3==0
        val b = number%5==0
        if(a && b){
            println("Fizzbuzz")
        }
        else if(a){
            println("Fizz")
        } else if(b){
            println("Buzz")
        } else {
            println(i)
        }
    }
}