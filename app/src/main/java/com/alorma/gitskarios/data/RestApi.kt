package com.alorma.gitskarios.data

import com.alorma.gitskarios.data.model.GithubNotificationApiModel
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class RestApi(private val httpClient: HttpClient) {

    suspend fun loadNotifications(): List<GithubNotificationApiModel> =
        httpClient.get("/notifications") {
            parameter("all", "true")
        }
}