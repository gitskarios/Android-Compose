package com.alorma.gitskarios.ui

import androidx.annotation.AttrRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import com.alorma.gitskarios.R
import com.google.android.material.color.MaterialColors

@Composable
fun GitskariosTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        darkColors(
            primary = getColorFromAndroidTheme(R.attr.colorPrimary),
            primaryVariant = getColorFromAndroidTheme(R.attr.colorPrimaryVariant),
            secondary = getColorFromAndroidTheme(R.attr.colorSecondary),
        )
    } else {
        lightColors(
            primary = getColorFromAndroidTheme(R.attr.colorPrimary),
            primaryVariant = getColorFromAndroidTheme(R.attr.colorPrimaryVariant),
            secondary = getColorFromAndroidTheme(R.attr.colorSecondary),
        )
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

@Composable
private fun getColorFromAndroidTheme(@AttrRes attrRes: Int): Color {
    val color = MaterialColors.getColor(ContextAmbient.current, attrRes, "GitskariosTheme")
    return Color(color)
}