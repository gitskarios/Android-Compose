package com.alorma.gitskarios.data.model

import com.google.gson.annotations.SerializedName

data class GithubNotificationApiModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("unread")
    val unread: Boolean,
    @SerializedName("subject")
    val subject: GithubNotificationSubjectApiModel
)

data class GithubNotificationSubjectApiModel(
    @SerializedName("title")
    val title: String
)