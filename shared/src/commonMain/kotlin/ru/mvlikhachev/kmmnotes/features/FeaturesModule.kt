package ru.mvlikhachev.kmmnotes.features

import org.kodein.di.DI
import ru.mvlikhachev.kmmnotes.features.auth_module.authModule

val featuresModule = DI.Module(
    name = "featuresModule",
    init = {
        importAll(
            authModule
        )
    }
)