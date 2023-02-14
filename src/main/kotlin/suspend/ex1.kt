package suspend

import kotlinx.coroutines.*

fun main() = runBlocking {
    val one = async { doOne() }
    val two = async { doTwo() }
    println(one.await() + two.await())
}

suspend fun doOne(): Int {
    delay(1000L)
    return 2
}

suspend fun doTwo(): Int {
    delay(1000L)
    return 3
}