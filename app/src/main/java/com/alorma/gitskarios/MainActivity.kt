package com.alorma.gitskarios

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.alorma.gitskarios.screen.notifications.NotificationsScreen
import com.alorma.gitskarios.ui.GitskariosTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitskariosTheme {
                NotificationsScreen()
            }
        }
    }
}