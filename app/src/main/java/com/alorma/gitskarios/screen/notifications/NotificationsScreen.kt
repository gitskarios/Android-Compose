package com.alorma.gitskarios.screen.notifications

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.onActive
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.ui.tooling.preview.Preview
import com.alorma.drawer_base.DebugDrawerLayout
import com.alorma.drawer_base.compositeOverSurface
import com.alorma.drawer_modules.BuildModule
import com.alorma.drawer_modules.DeviceModule
import com.alorma.gitskarios.BuildConfig
import com.alorma.gitskarios.R
import com.alorma.gitskarios.composables.NotificationItem
import com.alorma.gitskarios.composables.topBar
import com.alorma.gitskarios.screen.model.GithubNotificationItem
import com.alorma.gitskarios.ui.GitskariosTheme

@Composable
fun NotificationsScreen(
    notificationsViewModel: NotificationsViewModel = viewModel(),
) {
    DebugDrawerLayout(
        isDebug = { BuildConfig.DEBUG },
        drawerModules = {
            listOf(DeviceModule(), BuildModule())
        }
    ) {
        Scaffold(
            topBar = {
                topBar(stringRes = R.string.screen_title_notifications)
            },
        ) {
            onActive {
                notificationsViewModel.load()
            }
            val state = notificationsViewModel.userState.collectAsState()

            when (val value = state.value) {
                NotificationsState.Loading -> notificationsLoading()
                is NotificationsState.Data -> notificationsData(data = value)
            }
        }
    }
}

@Composable
fun notificationsLoading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        alignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colors.secondary
        )
    }
}

@Composable
fun notificationsData(data: NotificationsState.Data) {
    LazyColumnForIndexed(
        items = data.events,
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) { index, notification ->
        NotificationItem(notification)
        if (index < data.events.size - 1) {
            Divider(color = MaterialTheme.colors.surface)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationsLoadingPreview() {
    GitskariosTheme {
        notificationsLoading()
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationsDataPreview() {
    GitskariosTheme {
        val notification = GithubNotificationItem(
            id = "{abc}",
            read = true,
            origin = "user/repo #883",
            subject = "Hello dolly",
            reason = "subscribed",
        )
        val data = NotificationsState.Data(
            listOf(
                notification.copy(read = false),
                notification
            )
        )
        notificationsData(data = data)
    }
}