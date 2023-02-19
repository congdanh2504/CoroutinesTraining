package flowOperators

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun numbers(): Flow<Int> = flow {
    try {
        emit(1)
        emit(2)
        println("This line will not execute")
        emit(3)
    } finally {
        println("Finally in numbers")
    }
}

fun main() = runBlocking<Unit> {
    numbers()
        .take(2) // take only the first two
        .collect { value -> println(value) }
}
/**
 * 1
 * 2
 * Finally in numbers
 */