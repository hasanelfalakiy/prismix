package io.github.hasanelfalakiy.prismix.compose

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.Color
import io.github.hasanelfalakiy.prismix.core.color.PrismixColorScheme

internal fun PrismixColorScheme.toMaterial3(): ColorScheme {
    return lightColorScheme(
        primary = Color(primary),
        onPrimary = Color(onPrimary),
        primaryContainer = Color(primaryContainer),
        onPrimaryContainer = Color(onPrimaryContainer),

        secondary = Color(secondary),
        onSecondary = Color(onSecondary),
        secondaryContainer = Color(secondaryContainer),
        onSecondaryContainer = Color(onSecondaryContainer),

        tertiary = Color(tertiary),
        onTertiary = Color(onTertiary),
        tertiaryContainer = Color(tertiaryContainer),
        onTertiaryContainer = Color(onTertiaryContainer),

        background = Color(background),
        onBackground = Color(onBackground),

        surface = Color(surface),
        onSurface = Color(onSurface),
        surfaceVariant = Color(surfaceVariant),
        onSurfaceVariant = Color(onSurfaceVariant),

        outline = Color(outline),
        error = Color(error),
        onError = Color(onError),

        inverseSurface = Color(inverseSurface),
        inverseOnSurface = Color(inverseOnSurface),
        inversePrimary = Color(inversePrimary)
    )
}
