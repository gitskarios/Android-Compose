package com.alorma.gitskarios.utils

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

@Composable
fun Color.compositeOverSurface(alpha: Float = 1f): Color {
    if (this == MaterialTheme.colors.surface) {
        return this
    }
    return copy(alpha = alpha).compositeOver(MaterialTheme.colors.surface)
}