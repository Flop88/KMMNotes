package ru.mvlikhachev.kmmnotes.features.auth_module

interface AuthRemoteDataSource {
    suspend fun signUp(username: String, password: String): String
}