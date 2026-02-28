# Добро пожаловать в Kotlin! (welcome-to-kotlin)

[![Kotlin](https://img.shields.io/badge/kotlin-2.3.0-blue.svg)](https://kotlinlang.org)
[![Gradle](https://img.shields.io/badge/gradle-9.0.0-brightgreen.svg)](https://gradle.org)

Этот репозиторий содержит примеры кода для статьи **«Kotlin для новичков: от установки IDE до первого проекта»** на Habr.com.  
Здесь вы найдёте простые проекты, демонстрирующие:

- Настройку проекта Kotlin с **Gradle** (Kotlin DSL).
- Первую программу «Hello, Kotlin!».
- Совместное использование **Java и Kotlin** в одном проекте (вызов Java из Kotlin и наоборот).
- Основы структуры Kotlin-приложения.

Если вы только начинаете знакомство с языком, этот репозиторий станет отличной отправной точкой.

---

## 📦 Предварительные требования

- **JDK 21 или выше** (скачать можно с [Adoptium](https://adoptium.net/) или через IDE)
- **IntelliJ IDEA** (Community Edition достаточно) – [скачать здесь](https://www.jetbrains.com/idea/download/)

> 💡 Все примеры разрабатывались в IntelliJ IDEA, но должны работать и в других IDE с поддержкой Kotlin (Eclipse, VS Code с плагинами).

---

## 🚀 Быстрый старт

1. **Клонируйте репозиторий:**
   ```bash
   git clone https://github.com/sproshchaev/welcome-to-kotlin.git
   ```

2. **Откройте проект в IntelliJ IDEA:**
    - Запустите IDEA, выберите `Open` и укажите путь к клонированной папке.
    - Дождитесь импорта Gradle-проекта (IDEA скачает зависимости автоматически).

3. **Запустите примеры:**
    - Найдите файл `Main.kt` в `src/main/kotlin/ru/otus/` и нажмите зелёный треугольник рядом с функцией `main`.
    - Аналогично можно запустить `MainJava.java`, чтобы увидеть вызов Kotlin из Java.

---

## 📂 Структура проекта

```
.
├── src
│   ├── main
│   │   ├── kotlin
│   │   │   └── ru/otus
│   │   │       ├── Main.kt               # Точка входа (Hello, Kotlin!)
│   │   │       └── KotlinGreeter.kt       # Kotlin-объект с @JvmStatic
│   │   └── java
│   │       └── ru/otus
│   │           ├── JavaGreeter.java       # Java-класс со статическим методом
│   │           └── MainJava.java          # Точка входа на Java, вызывающая Kotlin
│   └── test                               # (пусто, для будущих тестов)
├── build.gradle.kts                       # Скрипт сборки Gradle (Kotlin DSL)
├── settings.gradle.kts                    # Настройки Gradle
└── README.md                              # Этот файл
```

---

## 🔍 Что внутри примеров

### `Main.kt`
```kotlin
package ru.otus

fun main() {
    println("Hello, Kotlin!")
    val message = JavaGreeter.greet("Kotlin")
    println(message)
}
```
Демонстрирует вызов Java-метода из Kotlin.

### `KotlinGreeter.kt`
```kotlin
package ru.otus

object KotlinGreeter {
    @JvmStatic
    fun greet(name: String): String = "Hello from Kotlin, $name!"
}
```
Объект с аннотацией `@JvmStatic`, чтобы метод можно было вызвать из Java как статический.

### `JavaGreeter.java`
```java
package ru.otus;

public class JavaGreeter {
    public static String greet(String name) {
        return "Hello from Java, " + name + "!";
    }
}
```

### `MainJava.java`
```java
package ru.otus;

public class MainJava {
    public static void main(String[] args) {
        System.out.println(KotlinGreeter.greet("Java"));
    }
}
```

---

## 📚 Полезные ссылки

- **Официальный сайт Kotlin** – [kotlinlang.org](https://kotlinlang.org) (документация, туториалы, блог)
- **Скачать IntelliJ IDEA** – [jetbrains.com/idea/download](https://www.jetbrains.com/idea/download/)
- **Курс «Kotlin Developer. Basic» на OTUS** – [otus.ru/lessons/kotlin-basic/](https://otus.ru/lessons/kotlin-basic/)  
  *Старт потока — март 2026. Идеально для новичков, желающих системно изучить Kotlin.*

---

## 🤝 Как использовать этот репозиторий

Вы можете:
- Клонировать и экспериментировать с кодом.
- Использовать как шаблон для своих Kotlin-проектов с Gradle.
- Предложить улучшения через Pull Request (если найдёте ошибку или добавите новый пример).

---

## 📄 Лицензия

Распространяется под лицензией MIT. Свободно используйте в учебных и коммерческих целях.

---

**Приятного изучения Kotlin!**  
Если остались вопросы — добро пожаловать в комментарии к статье или в Issues на GitHub.