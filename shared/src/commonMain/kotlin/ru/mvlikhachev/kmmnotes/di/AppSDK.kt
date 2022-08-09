package ru.mvlikhachev.kmmnotes.di

import org.kodein.di.*
import ru.mvlikhachev.kmmnotes.core.coreModule
import ru.mvlikhachev.kmmnotes.features.auth_module.authModule
import ru.mvlikhachev.kmmnotes.features.featuresModule
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object AppSDK {

    internal val di: DirectDI
        get() = requireNotNull(_di)
    private var _di: DirectDI? = null


    fun init(configuration: Configuration) {
        val configurationModule = DI.Module(
            name = "configurationModule",
            init = {
                bind<Configuration>() with singleton { configuration }
            }
        )

        if (_di != null) {
            _di = null
        }

        val direct = DI {
            importAll(
                configurationModule,
                featuresModule,
                coreModule
            )
        }.direct

        _di = direct
    }
}