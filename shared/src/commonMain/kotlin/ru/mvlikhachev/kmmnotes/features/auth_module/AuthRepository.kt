package ru.mvlikhachev.kmmnotes.features.auth_module

class AuthRepository(
    private val remoteDataSource: AuthRemoteDataSource
) {
    suspend fun signUp(username: String, password: String) =
        remoteDataSource.signUp(username, password)
}