package io.github.hasanelfalakiy.prismix.compose

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import io.github.hasanelfalakiy.prismix.core.manager.PrismixThemeManager

@Composable
fun PrismixTheme(
    content: @Composable () -> Unit
) {
    val themeState by PrismixThemeManager.theme.collectAsState()

    val theme = themeState
        ?: error("PrismixThemeManager has no theme set")

    val colorScheme = remember(theme) {
        theme.colors.toComposeColorScheme(theme.isDark)
    }

    CompositionLocalProvider(
        LocalPrismixTheme provides theme
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}
