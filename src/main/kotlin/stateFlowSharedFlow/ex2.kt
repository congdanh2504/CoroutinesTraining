package stateFlowSharedFlow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.*

fun main() = runBlocking {
    val state = MutableStateFlow("A")

    launch {
        state.collect { println("Value changed to $it") }
    }

    delay(1000)
    state.value = "B"

    delay(1000)
    launch {
        state.collect { println("and now it is $it") }
    }

    delay(1000)
    state.value = "C"
}
/**
 * Value changed to A
 * Value changed to B
 * and now it is B
 * Value changed to C
 * and now it is C
 */