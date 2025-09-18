package com.example.kotlinlesson1

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.kotlinlesson1.Book
import com.example.kotlinlesson1.Magazine
import com.example.kotlinlesson1.Type
import com.example.kotlinlesson1.User
import com.example.kotlinlesson1.Publication
import com.example.kotlinlesson1.adultValidation
import kotlinx.coroutines.handleCoroutineException


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

    val sum = { num1: Int, num2: Int -> println(num1 + num2) }
    sum(523, 42)


    val user1: User = User(1, "oleg", 19, Type.DEMO)
    println(user1.startTime)
    Thread.sleep(1000)
    println(user1.startTime)


    // Работа со списком
    val usersList = mutableListOf<User>(user1)
    usersList.addAll(
        listOf(
            User(2, "kizaru", 27, Type.FULL),
            User(3, "bogdan", 7, Type.DEMO),
            User(4, "petuh", 27, Type.FULL)
        )
    )

    /*
    usersList.apply {
        add(User(2, "kizaru", 27, Type.FULL))
        add(User(3, "bogdan", 7, Type.DEMO))
        add(User(4, "petuh", 27, Type.FULL))
    }
    */


    // Фильтрация
    val fullAccessUsersList = usersList.filter { it.type == Type.FULL }
    println("List of users with full access: $fullAccessUsersList")

    // Преобразование списка
    val transformedUsersList = usersList.map { it -> it.name }
    println("First element of transformed list: " + transformedUsersList.first())
    println("Last element of transformed list: " + transformedUsersList.last())


    // Проверка что пользователю больше 18 лет
    user1.adultValidation()


    // Авторизация
    val authorization = object : AuthCallback {
        override fun authSuccess() {
            println("Authorization Success!")
        }

        override fun authFailed() {
            println("Authorization Failed!")
        }
    }

    auth(user1, authorization) {
        println("cache updated")
    }


    val act = Login(user1)
    doAction(act, authorization)

}