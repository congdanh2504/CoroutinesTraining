package flowOperators

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    (1..3).asFlow() // a flow of requests
        .transform { request ->
            emit("Making request $request")
            emit(performRequest(request))
        }
        .collect { response -> println(response) }
}
/**
 * Making request 1
 * response 1
 * Making request 2
 * response 2
 * Making request 3
 * response 3
 */