package com.example.kotlinlesson1

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.kotlinlesson1.Type
import java.time.OffsetDateTime

@RequiresApi(Build.VERSION_CODES.O)
data class User(val id: Int, val name: String, val age: Int, val type: Type) {
    val startTime: OffsetDateTime by lazy { OffsetDateTime.now() }
}

