package com.alorma.gitskarios.screen.notifications

import com.alorma.gitskarios.screen.model.GithubUser

sealed class NotificationsState {
    object Loading: NotificationsState()
    data class Data(val user: GithubUser): NotificationsState()
}