package com.alorma.gitskarios.data.model

import com.alorma.gitskarios.screen.model.GithubUser
import com.google.gson.annotations.SerializedName

data class GithubRepositoryApiModel(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("owner")
    val owner: GithubUser,
)