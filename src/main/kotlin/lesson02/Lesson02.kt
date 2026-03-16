package ru.otus.lesson02

/**
 * Урок 2: Переменные, типы данных, строки, арифметика, ввод/вывод.
 * Содержит все ключевые примеры из статьи.
 */
fun main() {
    println("===== Урок 2: Переменные и базовые операции =====\n")
    variablesAndValues()
    dataTypesDemo()
    stringsAndTemplates()
    arithmeticOperations()
    typeConversionAndCoercion()
    readingInput()
    charactersAndUnicode()
    moduloDivision()
    incrementDecrement()
}

// 1. Переменные: val (неизменяемые) и var (изменяемые)
fun variablesAndValues() {
    println("--- 1. val / var ---")
    val immutable = "Kotlin"        // неизменяемая ссылка
    var mutable = 10                 // изменяемая ссылка
    println("immutable = $immutable, mutable = $mutable")
    mutable = 20
    println("mutable изменено на $mutable")
    // immutable = "Java" // Ошибка! val нельзя переназначить

    // Константы времени компиляции (const val) используются только на верхнем уровне или в object
    println()
}

// 2. Базовые типы данных и их свойства
fun dataTypesDemo() {
    println("--- 2. Типы данных ---")
    val intNumber: Int = 42
    val longNumber = 42L               // Long
    val doubleNumber = 3.1415           // Double
    val floatNumber = 2.5f              // Float
    val booleanValue = true
    val charValue = 'A'

    println("Int: $intNumber, Long: $longNumber, Double: $doubleNumber")
    println("Float: $floatNumber, Boolean: $booleanValue, Char: $charValue")

    // Свойства типов (диапазоны)
    println("Int range: ${Int.MIN_VALUE} .. ${Int.MAX_VALUE}")
    println("Double min positive: ${Double.MIN_VALUE}")
    println()
}

// 3. Строки и строковые шаблоны
fun stringsAndTemplates() {
    println("--- 3. Строки и шаблоны ---")
    val name = "Сергей"
    val age = 25
    println("Привет, $name! Через год тебе будет ${age + 1}.")

    // Многострочные строки (raw strings)
    val multiline = """
        |Это первая строка
        |Это вторая строка
        |Это третья строка
    """.trimMargin()
    println("Многострочная строка:\n$multiline")

    // Доступ к символам
    val str = "Kotlin"
    println("Первый символ: ${str[0]}, последний: ${str[str.length - 1]}")
    println()
}

// 4. Арифметические операции
fun arithmeticOperations() {
    println("--- 4. Арифметика ---")
    val a = 10
    val b = 3
    println("$a + $b = ${a + b}")
    println("$a - $b = ${a - b}")
    println("$a * $b = ${a * b}")
    println("$a / $b = ${a / b}  (целочисленное деление)")
    println("$a.toDouble() / $b = ${a.toDouble() / b}  (вещественное)")
    println()
}

// 5. Преобразование типов (type conversion) и приведение (coercion)
fun typeConversionAndCoercion() {
    println("--- 5. Преобразование типов ---")
    val intValue = 100
    val doubleValue = intValue.toDouble()   // явное преобразование
    val stringValue = intValue.toString()
    println("int $intValue -> double $doubleValue, string \"$stringValue\"")

    // Неявное приведение при смешивании типов
    val result = 10 + 3.5   // Int + Double -> Double
    println("10 + 3.5 = $result (тип: ${result::class.simpleName})")
    println()
}

// 6. Чтение данных с консоли (readln)
fun readingInput() {
    println("--- 6. Ввод данных ---")
    print("Введите ваше имя: ")
    val userName = readln()
    print("Введите ваш возраст: ")
    val age = readln().toInt()
    println("Привет, $userName! В следующем году вам будет ${age + 1}.")
    println()
}

// 7. Символы и Unicode
fun charactersAndUnicode() {
    println("--- 7. Символы и Unicode ---")
    val letterA = 'A'
    val delta = '\u0394'   // Δ
    val sigma = 'Σ'
    println("Буква A: $letterA, код: ${letterA.code}")
    println("Дельта: $delta, Сигма: $sigma")

    // Символ — не число, арифметика запрещена
    // println(letterA + 1) // Ошибка!
    println()
}

// 8. Остаток от деления (modulo) с отрицательными числами
fun moduloDivision() {
    println("--- 8. Остаток от деления (%) ---")
    println("10 % 3  = ${10 % 3}")   // 1
    println("10 % -3 = ${10 % -3}")  // 1 (знак делимого)
    println("-10 % 3 = ${-10 % 3}")  // -1 (знак делимого)
    println()
}

// 9. Инкремент и декремент
fun incrementDecrement() {
    println("--- 9. Инкремент / декремент ---")
    var counter = 5
    println("counter = $counter")
    println("postfix (counter++): ${counter++}") // выведет 5, затем станет 6
    println("после postfix: $counter")
    println("prefix (++counter): ${++counter}")  // увеличит до 7 и выведет 7
    println()
}