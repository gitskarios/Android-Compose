package com.alorma.gitskarios.screen.model

data class GithubNotificationItem(
    val id: String,
    val read: Boolean,
    val origin: String,
    val subject: String,
    val reason: String
)