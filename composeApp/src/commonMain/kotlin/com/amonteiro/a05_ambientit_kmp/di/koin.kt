package com.amonteiro.a05_ambientit_kmp.di

import com.amonteiro.a05_ambientit_kmp.data.remote.KtorWeatherApi
import com.amonteiro.a05_ambientit_kmp.presentation.viewmodel.MainViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

//Si besoin du contexte, pour le passer en paramètre au lancement de Koin
fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(apiModule, viewModelModule)
    }.koin

// Version pour iOS et Desktop
fun initKoin() = initKoin {}

val apiModule = module {

    single {
        HttpClient {
            install(Logging) {
                //(import io.ktor.client.plugins.logging.Logger)
                logger = object : Logger {
                    override fun log(message: String) {
                        println(message)
                    }
                }
                level = LogLevel.INFO  // TRACE, HEADERS, BODY, etc.
            }
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 5000
            }
            //engine { proxy = ProxyBuilder.http("monproxy:1234") }
        }
    }

    singleOf(::KtorWeatherApi)

}

val viewModelModule = module {
    viewModelOf(::MainViewModel)
}