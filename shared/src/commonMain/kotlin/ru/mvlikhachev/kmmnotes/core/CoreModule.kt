package ru.mvlikhachev.kmmnotes.core

import org.kodein.di.DI
import ru.mvlikhachev.kmmnotes.core.ktor.ktorModule
import ru.mvlikhachev.kmmnotes.core.serialization.serializationModule

val coreModule = DI.Module(
    name = "CoreModule",
    init = {
         importAll(
             ktorModule,
             serializationModule
         )
    }
)