package com.example.kotlinlesson1

sealed class Action {}

class Registration : Action() {}

class Login (val user : User) : Action() {}

class Logout : Action() {}