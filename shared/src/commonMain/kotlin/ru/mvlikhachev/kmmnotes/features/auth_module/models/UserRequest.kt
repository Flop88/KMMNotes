package ru.mvlikhachev.kmmnotes.features.auth_module.models

import kotlinx.serialization.Serializable

@Serializable
data class UserRequest(
    val username: String,
    val password: String
)