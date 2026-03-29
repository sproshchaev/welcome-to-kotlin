package ru.otus.lesson04

/**
 * Урок 4: Функции — декомпозиция, аргументы, области видимости.
 * Содержит все ключевые примеры из статьи.
 */
fun main() {
    println("==== Урок 4: Функции ====\n")
    simpleFunctionExample()
    namedAndDefaultArguments()
    functionExpressions()
    scopesAndCallStack()
    functionalDecomposition()
    realWorldBonusExample()
}

// 1. Простейшая функция
fun simpleFunctionExample() {
    println("--- 1. Простейшая функция ---")
    val message = greetUser("Алексей")
    println(message)
    // single-expression function
    println(greetUserShort("Мария"))
}

fun greetUser(name: String): String {
    return "Привет, $name! Добро пожаловать в OTUS."
}

// Single-expression function (тело из одного выражения)
fun greetUserShort(name: String): String = "Привет, $name!"

// 2. Именованные аргументы и значения по умолчанию
fun namedAndDefaultArguments() {
    println("\n--- 2. Именованные аргументы и значения по умолчанию ---")
    sendNotification("user123", "Привет!")
    sendNotification("user456", "Срочно!", priority = 5)
    sendNotification(
        userId = "user789",
        message = "Важное обновление",
        isSilent = true,
        priority = 10
    )
}

fun sendNotification(
    userId: String,
    message: String,
    priority: Int = 1,
    isSilent: Boolean = false,
    retryCount: Int = 0
) {
    println("Отправка $userId: $message (приоритет $priority, без звука: $isSilent)")
}

// 3. Функции как выражения
fun functionExpressions() {
    println("\n--- 3. Функции как выражения ---")
    val a = 15
    val b = 20
    val max = if (a > b) a else b
    println("Максимум из $a и $b = $max")

    val commission = calculateCommission(500.0)
    println("Комиссия: $commission")
}

fun calculateCommission(amount: Double): Double {
    return if (amount >= 1000.0) {
        println("Применяем фиксированную комиссию")
        50.0
    } else {
        println("Применяем процентную комиссию")
        amount * 0.02
    }
}

// 4. Области видимости и стек вызовов (демонстрация)
fun scopesAndCallStack() {
    println("\n--- 4. Области видимости ---")
    outerFunction()
}

fun outerFunction() {
    val x = 10 // x доступна только здесь

    fun innerFunction() {
        val y = 20 // y доступна только здесь
        // Внутренняя функция видит x из внешней
        println("Внутренняя функция: x + y = ${x + y}")
    }

    innerFunction()
    // println(y) // Ошибка компиляции: y недоступна
}

// 5. Функциональная декомпозиция (расчёт бонуса)
fun functionalDecomposition() {
    println("\n--- 5. Декомпозиция: расчёт бонуса ---")
    val (name, experience) = readEmployeeInfo()
    val isManager = name.contains("Руководитель", ignoreCase = true)
    val bonus = calculateBonus(experience, isManager)
    val message = formatBonusMessage(name, bonus)
    println(message)
}

fun calculateBonus(yearsOfService: Int, isManager: Boolean): Double {
    val baseBonus = if (yearsOfService > 5) 1000.0 else 500.0
    val multiplier = if (isManager) 1.5 else 1.0
    return baseBonus * multiplier
}

fun formatBonusMessage(employeeName: String, bonus: Double): String {
    return "Сотрудник $employeeName, ваш бонус: %.2f рублей".format(bonus)
}

fun readEmployeeInfo(): Pair<String, Int> {
    println("Введите имя сотрудника:")
    val name = readln()
    println("Введите стаж (лет):")
    val experience = readln().toIntOrNull() ?: 0
    return Pair(name, experience)
}

// 6. Реальный пример из FinTech (Single Source of Truth)
fun realWorldBonusExample() {
    println("\n--- 6. Реальный пример: единый источник истины ---")
    println("Кэшбэк для суммы 12 000: ${calculateCashback(12000.0)}")
    println("Кэшбэк для суммы 20 000: ${calculateCashback(20000.0)}")
}

fun calculateCashback(amount: Double): Double {
    return if (amount > 15000) amount * 0.05 else amount * 0.02
}