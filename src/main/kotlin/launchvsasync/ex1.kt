package launchvsasync

import kotlinx.coroutines.*

fun main() = runBlocking {
    var resultOne = "Android"
    var resultTwo = "Kotlin"
    println("Launch before")
    launch { resultOne = function1() }
    launch { resultTwo = function2() }
    println("Launch after")
    val resultText = resultOne + resultTwo
    println("Launch $resultText")
}

suspend fun function1(): String {
    delay(1000L)
    println("function1")
    return "function1"
}

suspend fun function2(): String {
    delay(1000L)
    println("function2")
    return "function2"
}
/**
 * Result:
 * Launch before
 * Launch after
 * Launch AndroidKotlin
 * function1
 * function2
 */