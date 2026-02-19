package io.github.hasanelfalakiy.prismix.compose

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.Color
import io.github.hasanelfalakiy.prismix.core.model.PrismixColorScheme

internal fun PrismixColorScheme.toComposeColorScheme(
    isDark: Boolean
): ColorScheme {

    val primaryColor = Color(primary)
    val onPrimaryColor = Color(onPrimary)
    val backgroundColor = Color(background)
    val onBackgroundColor = Color(onBackground)
    val surfaceColor = Color(surface)
    val onSurfaceColor = Color(onSurface)

    return if (isDark) {
        darkColorScheme(
            primary = primaryColor,
            onPrimary = onPrimaryColor,
            background = backgroundColor,
            onBackground = onBackgroundColor,
            surface = surfaceColor,
            onSurface = onSurfaceColor
        )
    } else {
        lightColorScheme(
            primary = primaryColor,
            onPrimary = onPrimaryColor,
            background = backgroundColor,
            onBackground = onBackgroundColor,
            surface = surfaceColor,
            onSurface = onSurfaceColor
        )
    }
}
