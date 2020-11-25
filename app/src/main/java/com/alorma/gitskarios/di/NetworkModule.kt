package com.alorma.gitskarios.di

import android.util.Log
import com.alorma.gitskarios.BuildConfig
import com.alorma.gitskarios.data.RestApi
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import okhttp3.Interceptor
import org.koin.dsl.module

object NetworkModule {

    operator fun invoke() = module {
        factory { RestApi(httpClient = get()) }

        single<HttpClient> {
            HttpClient(OkHttp) {
                engine {
                    getAll<Interceptor>().forEach { addInterceptor(it) }
                }
                install(JsonFeature) {
                    serializer = GsonSerializer()
                }
                install(Logging) {
                    logger = object : Logger {
                        override fun log(message: String) {
                            Log.d("Alorma", message)
                        }
                    }
                    level = LogLevel.ALL
                }
                defaultRequest {
                    header("Authorization", "token ${BuildConfig.GH_TOKEN}")
                }
            }
        }
    }

}