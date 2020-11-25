package com.alorma.gitskarios.data

import com.alorma.gitskarios.data.model.GithubNotificationApiModel
import com.alorma.gitskarios.data.model.GithubUserApiModel
import io.ktor.client.*
import io.ktor.client.request.*

class RestApi(private val httpClient: HttpClient) {

    suspend fun loadUser(): GithubUserApiModel {
        return httpClient.get("/user")
    }

    suspend fun loadNotifications(): List<GithubNotificationApiModel> {
        return httpClient.get("/notifications")
    }
}