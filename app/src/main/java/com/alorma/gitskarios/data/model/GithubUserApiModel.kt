package com.alorma.gitskarios.data.model

import com.google.gson.annotations.SerializedName

data class GithubUserApiModel(
    @SerializedName("login")
    val login: String,
)