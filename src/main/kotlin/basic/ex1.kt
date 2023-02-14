package basic

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        delay(1000L)
        println("World!")
    }
    print("Hello ")
}
/**
 * Result: Hello (delay 1s) World!
 */