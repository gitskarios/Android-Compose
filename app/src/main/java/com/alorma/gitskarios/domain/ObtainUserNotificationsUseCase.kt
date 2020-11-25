package com.alorma.gitskarios.domain

import com.alorma.gitskarios.data.RestApi
import com.alorma.gitskarios.screen.model.GithubNotificationItem

class ObtainUserNotificationsUseCase(private val restApi: RestApi) {

    suspend fun loadNotifications(): List<GithubNotificationItem> {
        return restApi.loadNotifications().sortedBy { it.unread }.map { notification ->
            GithubNotificationItem(
                id = notification.id,
                read = !notification.unread,
                origin = "${notification.repository.owner.login}/${notification.repository.name}",
                subject = notification.subject.title,
                reason = notification.reason,
            )
        }
    }

}