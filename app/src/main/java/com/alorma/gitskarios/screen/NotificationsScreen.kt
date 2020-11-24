package com.alorma.gitskarios.screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.ui.tooling.preview.Preview
import com.alorma.drawer_base.DebugDrawerLayout
import com.alorma.drawer_modules.BuildModule
import com.alorma.drawer_modules.DeviceModule
import com.alorma.gitskarios.BuildConfig
import com.alorma.gitskarios.R
import com.alorma.gitskarios.composables.topBar
import com.alorma.gitskarios.ui.GitskariosTheme

@Composable
fun NotificationsScreen() {
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

        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationsScreenPreview() {
    GitskariosTheme {
        NotificationsScreen()
    }
}