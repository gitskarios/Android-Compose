package com.alorma.gitskarios.data.model

import com.google.gson.annotations.SerializedName

data class GithubGenericApiModel(
    @SerializedName("id")
    val id: Long
)