package com.alorma.gitskarios.di

import android.util.Log
import com.alorma.gitskarios.BuildConfig
import com.alorma.gitskarios.data.RestApi
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.URLProtocol
import org.koin.dsl.module

object NetworkModule {

    operator fun invoke() = module {
        factory { RestApi(httpClient = get()) }

        single<HttpClient> {
            HttpClient(OkHttp) {
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
                    header("Accept", "application/vnd.github.v3+json")
                    url {
                        protocol = URLProtocol.HTTPS
                        host = BuildConfig.GH_HOST
                        if (encodedPath.startsWith("/api/v3").not()) {
                            path("api", "v3", encodedPath)
                        }
                    }
                }
            }
        }
    }

}