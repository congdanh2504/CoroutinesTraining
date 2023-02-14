package basic

import kotlinx.coroutines.*

fun main() = runBlocking {
    doWorld()
    println("Done !")
}

suspend fun doWorld() = coroutineScope {
    launch {
        delay(1000L)
        print("World 1! ")
    }
    launch {
        delay(2000L)
        print("World 2! ")
    }
    print("Hello ")
}
/**
 * Result: Hello (delay 1s) World 1! (delay 1s) World 2! Done
 */
