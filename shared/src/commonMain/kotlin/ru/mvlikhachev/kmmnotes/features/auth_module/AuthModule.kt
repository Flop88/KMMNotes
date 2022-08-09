package ru.mvlikhachev.kmmnotes.features.auth_module

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import ru.mvlikhachev.kmmnotes.di.AppSDK
import ru.mvlikhachev.kmmnotes.features.auth_module.ktor.KtorAuthDataSource
import kotlin.native.concurrent.ThreadLocal

internal val authModule = DI.Module(
    name = "AuthModule",
    init = {
        bind<AuthRemoteDataSource>() with singleton {
            KtorAuthDataSource(
                json = instance(),
                httpClient = instance()
            )
        }
        bind<AuthRepository>() with singleton {
            AuthRepository(remoteDataSource = instance())
        }
    }
)

@ThreadLocal
object AuthModule {
    val authRepository: AuthRepository
        get() = AppSDK.di.instance()
}

val AppSDK.auth: AuthModule
    get() = AuthModule