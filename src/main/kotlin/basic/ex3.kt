package basic

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")
    job.join()
    println("Done")
}
/**
 * Result: Hello (delay 1s) World! Done
 */
