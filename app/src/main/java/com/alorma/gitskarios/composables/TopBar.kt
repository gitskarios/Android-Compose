package com.alorma.gitskarios.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun topBar(
    @StringRes stringRes: Int,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = stringRes))
        },
        navigationIcon = navigationIcon,
        actions = actions
    )
}