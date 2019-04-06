package com.example.textinputlayout

data class User(
    var name: String,
    var surname: String,
    var age: Int? = 0,
    var another: String? = null
) {
}