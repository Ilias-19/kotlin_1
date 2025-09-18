package com.example.kotlinlesson1

import com.example.kotlinlesson1.Publication

class Book(override val price: Double, override val wordCount: Int) : Publication {
    override fun getType(): String {
        return when {
            wordCount <= 1000 -> "Flash Fiction"
            wordCount <= 7500 -> "Short Story"
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