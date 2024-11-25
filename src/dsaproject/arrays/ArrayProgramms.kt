package dsaproject.arrays

fun main(){

//    printNumberTriangle(5)
    printPyramidPrint(10)
}

/**
 * Print triangle pattern
 */
fun printNumberTriangle(n:Int){
    var a=IntArray(5)
    a.size
    for(i in 1..n){
        for (j in 1..i){
            print("$j ")
        }
        println()
    }
}

/**
 * Print the Pyramid pattern
 */
fun printPyramidPrint(n : Int) {
    for (i in 1..n) {
        for (j in 1..n - i) {
            print(" ")
        }
        for (k in 1..(2 * i - 1)) {
            print(" *")
        }
        println()
    }
}