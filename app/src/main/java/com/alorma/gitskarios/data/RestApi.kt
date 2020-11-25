package com.alorma.gitskarios.data

import com.alorma.gitskarios.BuildConfig
import com.alorma.gitskarios.data.model.GithubUserApiModel
import io.ktor.client.*
import io.ktor.client.request.*

class RestApi(private val httpClient: HttpClient) {

    suspend fun loadUser(): GithubUserApiModel {
        return httpClient.get("/user".buildHost())
    }

    private fun String.buildHost() = "https://${BuildConfig.GH_HOST}/api/v3${this}"
}