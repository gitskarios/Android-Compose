package com.alorma.gitskarios.composables

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.AmbientEmphasisLevels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideEmphasis
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.alorma.gitskarios.screen.model.GithubNotificationItem
import com.alorma.gitskarios.ui.GitskariosTheme
import com.alorma.gitskarios.utils.compositeOverSurface

@Composable
fun NotificationItem(notification: GithubNotificationItem) {

    val alpha = if (notification.read) {
        0.20f
    } else {
        0.10f
    }

    val color = if (notification.read) {
        MaterialTheme.colors.onSurface.compositeOverSurface(alpha / 2)
    } else {
        MaterialTheme.colors.surface
    }
    Surface(
        color = color
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .clickable(onClick = {})
                .padding(8.dp)
        ) {
            ProvideEmphasis(emphasis = AmbientEmphasisLevels.current.medium) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = notification.origin,
                    style = MaterialTheme.typography.caption,
                )
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = notification.subject,
                fontWeight = if (notification.read) {
                    FontWeight.Normal
                } else {
                    FontWeight.Bold
                }
            )
            Spacer(modifier = Modifier.preferredHeight(4.dp))
            Text(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colors.onSurface.compositeOverSurface(alpha),
                        shape = MaterialTheme.shapes.small,
                    )
                    .background(MaterialTheme.colors.onSurface.compositeOverSurface(alpha))
                    .padding(4.dp),
                text = notification.reason.replace("_", " "),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationItemReadPreview() {
    GitskariosTheme {
        val notification = GithubNotificationItem(
            id = "{abc}",
            read = true,
            origin = "user/repo #883",
            subject = "Hello dolly",
            reason = "subscribed",
        )
        NotificationItem(notification = notification)
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationItemNotReadPreview() {
    GitskariosTheme {
        val notification = GithubNotificationItem(
            id = "{abc}",
            read = false,
            origin = "user/repo #883",
            subject = "Hello dolly",
            reason = "subscribed",
        )
        NotificationItem(notification = notification)
    }
}