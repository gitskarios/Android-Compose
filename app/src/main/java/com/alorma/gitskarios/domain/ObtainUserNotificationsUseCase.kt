package com.alorma.gitskarios.domain

import com.alorma.gitskarios.data.RestApi
import com.alorma.gitskarios.screen.model.GithubNotificationItem

class ObtainUserNotificationsUseCase(private val restApi: RestApi) {

    suspend fun loadNotifications(): List<GithubNotificationItem> {
        return restApi.loadNotifications(true)
            .sortedByDescending { it.unread }
            .map { notification ->
                GithubNotificationItem(
                    id = notification.id,
                    read = !notification.unread,
                    origin = notification.repository.fullName,
                    subject = notification.subject.title,
                    reason = notification.reason,
                )
            }
    }

}