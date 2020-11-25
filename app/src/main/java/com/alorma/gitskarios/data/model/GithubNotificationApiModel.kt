package com.alorma.gitskarios.data.model

import com.google.gson.annotations.SerializedName

data class GithubNotificationApiModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("unread")
    val unread: Boolean,
    @SerializedName("repository")
    val repository: GithubRepositoryApiModel,
    @SerializedName("subject")
    val subject: GithubNotificationSubjectApiModel,
    @SerializedName("reason")
    val reason: String
)

data class GithubNotificationSubjectApiModel(
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)