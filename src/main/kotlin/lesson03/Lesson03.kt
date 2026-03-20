package ru.otus.lesson03

/**
 * Урок 3: Управляющие конструкции – условия, циклы, диапазоны.
 *
 * Темы:
 * - Boolean и операции сравнения
 * - if как выражение
 * - when (замена switch, проверка типов, диапазоны)
 * - Диапазоны (ranges)
 * - Циклы for, while, repeat
 * - Метки и jumps (break, continue)
 */
fun main() {
    println("=== Урок 3: Управляющие конструкции ===")

    // Раскомментируйте нужные вызовы для запуска примеров
    // ifExpressionExample()
    // whenExample()
    // rangesExample()
    // forLoopExample()
    // whileExample()
    // repeatExample()
    // labelsExample()
}

// ----------------------------------------------
// 1. if как выражение
// ----------------------------------------------
fun ifExpressionExample() {
    println("\n--- if как выражение ---")
    val a = 15
    val b = 20
    val max = if (a > b) a else b
    println("Максимум из $a и $b = $max")

    fun calculateFee(amount: Double): Double = if (amount >= 1000.0) {
        println("Фиксированная комиссия")
        50.0
    } else {
        println("Процентная комиссия")
        amount * 0.02
    }

    println("Комиссия для 500.0: ${calculateFee(500.0)}")
    println("Комиссия для 1500.0: ${calculateFee(1500.0)}")
}

// ----------------------------------------------
// 2. when – во всём его великолепии
// ----------------------------------------------
fun whenExample() {
    println("\n--- when ---")

    // 2.1 Простая замена switch
    fun httpStatus(code: Int): String = when (code) {
        200 -> "OK"
        404 -> "Not Found"
        500 -> "Internal Server Error"
        else -> "Unknown"
    }
    println("HTTP 404: ${httpStatus(404)}")

    // 2.2 Проверка на вхождение в диапазон
    fun temperatureCategory(celsius: Int): String = when (celsius) {
        in -50..0 -> "Морозно"
        in 1..15 -> "Прохладно"
        in 16..30 -> "Тепло"
        in 31..50 -> "Жарко"
        else -> "Экстремально"
    }
    println("Температура 22°C: ${temperatureCategory(22)}")

    // 2.3 Проверка типа (is)
    fun printType(obj: Any) = when (obj) {
        is String -> println("Строка длиной ${obj.length}")
        is Int -> println("Число: $obj")
        else -> println("Что-то другое")
    }
    printType("Kotlin")
    printType(42)

    // 2.4 when без аргумента (как замена if-else if)
    fun getDiscount(customerType: String, years: Int, amount: Double): Double = when {
        customerType == "vip" && years > 5 -> 0.20
        customerType == "vip" -> 0.15
        amount > 10000 -> 0.10
        years > 3 -> 0.05
        else -> 0.0
    }
    println("Скидка для vip (2 года): ${getDiscount("vip", 2, 500.0)}")
    println("Скидка для обычного (4 года, 20000): ${getDiscount("regular", 4, 20000.0)}")
}

// ----------------------------------------------
// 3. Диапазоны (Ranges)
// ----------------------------------------------
fun rangesExample() {
    println("\n--- Диапазоны ---")
    val oneToTen = 1..10
    val tenToOne = 10 downTo 1
    val evenNumbers = 0..100 step 2
    val letters = 'A'..'Z'

    println("5 in 1..10 : ${5 in oneToTen}")
    println("15 in 1..10: ${15 in oneToTen}")
    println("'C' in A..Z : ${'C' in letters}")

    for (i in 1..5) print("$i ")
    println()
    for (i in 5 downTo 1 step 2) print("$i ")
    println()
}

// ----------------------------------------------
// 4. Цикл for
// ----------------------------------------------
fun forLoopExample() {
    println("\n--- Цикл for ---")

    val fruits = listOf("Apple", "Banana", "Orange")

    // Перебор по индексам
    for (index in fruits.indices) {
        println("$index -> ${fruits[index]}")
    }

    // Перебор с индексом и значением (best practice)
    for ((index, fruit) in fruits.withIndex()) {
        println("$index -> $fruit")
    }

    // Итерация по диапазону
    for (i in 1..3) {
        for (j in 1..3) {
            print("($i,$j) ")
        }
        println()
    }
}

// ----------------------------------------------
// 5. Циклы while и do-while
// ----------------------------------------------
fun whileExample() {
    println("\n--- while / do-while ---")

    var x = 3
    while (x > 0) {
        println("while: осталось $x")
        x--
    }

    var input: String?
    var attempts = 0
    do {
        print("Введите 'exit' для выхода: ")
        input = readlnOrNull()
        attempts++
    } while (input != "exit" && attempts < 3)
    println("Цикл завершён, попыток: $attempts")
}

// ----------------------------------------------
// 6. repeat – простая вещь, которую многие не знают
// ----------------------------------------------
fun repeatExample() {
    println("\n--- repeat ---")
    repeat(3) { iteration ->
        println("Повторение $iteration")
    }
}

// ----------------------------------------------
// 7. Метки (labels) для break и continue
// ----------------------------------------------
fun labelsExample() {
    println("\n--- Метки ---")
    outer@ for (i in 1..3) {
        for (j in 1..3) {
            if (i == 2 && j == 2) {
                println("Нашли (2,2)! Выходим из внешнего цикла")
                break@outer
            }
            println("i=$i, j=$j")
        }
    }
    println("Готово")
}