package com.example.recyclerexample

class MyEntity(var name: String, var nationality: Nationality, var title: Boolean = false, var showingChilds: Boolean = false)

enum class Nationality {
    BRAZILIAN,
    AMERICAN
}