package com.example.kotlinlesson1

fun buy(publication: Publication) {
    println("The purchase is complete. The purchase amount was ${publication.price}")
}


fun User.adultValidation() {
    if (this.age >= 18) {
        println("User: $this - is over 18 years old")
    } else throw RuntimeException("error adult validation")
}

inline fun auth(user: User, authorization: AuthCallback, updateCache: () -> Unit) {
    try {
        user.adultValidation()
        authorization.authSuccess()
        updateCache()
    }
    catch (e: Exception) {
        authorization.authFailed()
    }
}


fun doAction(act : Action, authorization : AuthCallback) {
    when (act) {
        is Registration -> println("Registration started")
        is Login -> auth(act.user, authorization) {
            println("cache updated")
        }
        is Logout -> println("Logout")
    }
}