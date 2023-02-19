package flowOperators

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking


fun main() = runBlocking<Unit> {
    (1..3).asFlow() // a flow of requests
        .filter { request -> request > 1 }
        .map { request -> performRequest(request) }
        .collect { response -> println(response) }
}
/**
 * response 2
 * response 3
 */