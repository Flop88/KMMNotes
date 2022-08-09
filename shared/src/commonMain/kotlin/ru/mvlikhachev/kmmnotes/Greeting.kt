package ru.mvlikhachev.kmmnotes

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
    fun getName(name: String): String {
        return "Name is: $name"
    }
}