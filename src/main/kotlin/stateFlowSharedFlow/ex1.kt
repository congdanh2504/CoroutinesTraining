package stateFlowSharedFlow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val mutableSharedFlow =
        MutableSharedFlow<String>(replay = 0)

    launch {
        mutableSharedFlow.collect {
            println("#1 received $it")
        }
    }
    launch {
        mutableSharedFlow.collect {
            println("#2 received $it")
        }
    }

    delay(1000)
    mutableSharedFlow.emit("Message1")
    mutableSharedFlow.emit("Message2")
}
/**
 * #1 received Message1
 * #2 received Message1
 * #1 received Message2
 * #2 received Message2
 */