package com.example.kotlinlesson1
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.LocalTime

interface Publication {
    val price : Double
    val wordCount : Int
    fun getType() : String
}

class Book(override val price: Double, override val wordCount: Int) : Publication {
    override fun getType() : String {
        return when {
            wordCount <= 1000 -> "Flash Fiction"
            wordCount <=  7500 -> "Short Story"
            else -> "Novel"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        val book = other as Book
        return book.wordCount == wordCount && book.price == price
    }

    override fun hashCode(): Int {
        var result = price.hashCode()
        result = 31 * result + wordCount
        return result
    }
}

class Magazine(override val price: Double, override val wordCount: Int) : Publication {
    override fun getType() : String {
        return "Magazine"
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    val book1: Book = Book(1999.996546, 5724)
    val book2: Book = Book(1999.996546, 5724)
    val magazine1: Magazine = Magazine(450.55346, 900)

    println("book1 price: ${"%.2f".format(book1.price)} EUR, word count: ${book1.wordCount}, type: ${book1.getType()}")
    println("book2 price: ${"%.2f".format(book2.price)} EUR, word count: ${book2.wordCount}, type: ${book2.getType()}")
    println("magazine1 price: ${"%.2f".format(magazine1.price)} EUR, word count: ${magazine1.wordCount}, type: ${magazine1.getType()}")

    println(book1 === book2)
    println(book1 == book2)

    val book3: Book? = null
    val book4: Book = Book(1.355, 534)
    book3?.let {
        buy(it)
    }
    buy(book4)

    val sum = {num1:Int, num2:Int -> println(num1 + num2)}
    sum(523,42)


    val user1 : User = User(1, "oleg", 19, Type.DEMO)
    println(user1.startTime)
    Thread.sleep(1000)
    println(user1.startTime)
}

fun buy(publication: Publication) {
    println("The purchase is complete. The purchase amount was ${publication.price}")
}


enum class Type {
    DEMO, FULL
}

@RequiresApi(Build.VERSION_CODES.O)
data class User(val id: Int, val name: String, val age: Int, val type : Type) {
    val startTime: LocalTime by lazy { LocalTime.now() }
}