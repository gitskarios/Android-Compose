package com.alorma.gitskarios.screen.notifications

import com.alorma.gitskarios.screen.model.GithubNotificationItem

sealed class NotificationsState {
    object Loading : NotificationsState()
    data class Data(val events: List<GithubNotificationItem>) : NotificationsState()
}