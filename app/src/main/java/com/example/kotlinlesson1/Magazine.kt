package com.example.kotlinlesson1

import com.example.kotlinlesson1.Publication

class Magazine(override val price: Double, override val wordCount: Int) : Publication {
    override fun getType(): String {
        return "Magazine"
    }
}