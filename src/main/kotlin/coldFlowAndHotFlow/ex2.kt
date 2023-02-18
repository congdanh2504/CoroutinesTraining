package coldFlowAndHotFlow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun hotFlow(): SharedFlow<Int> {
    return simple().shareIn(replay = 1, scope = GlobalScope, started = SharingStarted.WhileSubscribed())
}

fun main() = runBlocking {
    val hotFlow = hotFlow()
    launch {
        hotFlow.collect() {
            println("1st Collector: $it")
        }
    }
    delay(1000)
    launch {
        hotFlow.collect() {
            println("2nd Collector: $it")
        }
    }
    delay(1000)
    println("Done")
}
/**
 * Flow started
 * 1st Collector: 1
 * 1st Collector: 2
 * 1st Collector: 3
 * 2nd Collector: 3
Done
 */