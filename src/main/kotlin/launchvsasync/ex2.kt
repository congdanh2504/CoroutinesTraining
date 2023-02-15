package launchvsasync

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Launch before")
    val resultOne = async { function1() }
    val resultTwo = async { function2() }
    println("Launch after")
    val resultText = resultOne.await() + resultTwo.await()
    println("Launch $resultText")
}
/**
 * Result:
 * Launch before
 * Launch after
 * function1
 * function2
 * Launch function1function2
 */