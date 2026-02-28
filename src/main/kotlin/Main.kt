package ru.otus

fun main() {

    println("Hello, Kotlin!")

    val message = JavaGreeter.greet("Kotlin")
    println(message)

}

object KotlinGreeter {
    @JvmStatic
    fun greet(name: String): String = "Hello from Kotlin, $name!"
}