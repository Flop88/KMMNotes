package ru.mvlikhachev.kmmnotes.features.auth_module.ktor

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import ru.mvlikhachev.kmmnotes.features.auth_module.AuthRemoteDataSource
import ru.mvlikhachev.kmmnotes.features.auth_module.models.UserRequest

class KtorAuthDataSource(
    private val httpClient: HttpClient,
    private val json: Json
): AuthRemoteDataSource {
    override suspend fun signUp(username: String, password: String): String {
        val userData = UserRequest(username, password)
        val httpRequest = httpClient.get<HttpStatement> {
            url {
                path("secret")
//                body = json.encodeToJsonElement(UserRequest.serializer( ), userData)
            }
        }
        return httpRequest.execute().readText()
    }
}