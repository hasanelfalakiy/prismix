package io.github.hasanelfalakiy.prismix.core.color

import io.github.hasanelfalakiy.prismix.core.token.PrismixColorTokens

object PrismixSchemeFactory {

    fun create(
        tokens: PrismixColorTokens,
        overrides: PrismixColorOverrides? = null
    ): PrismixColorScheme {

        val primaryPalette =
            PrismixTonalGenerator.fromSeed(tokens.seedPrimary)

        val secondaryPalette =
            PrismixTonalGenerator.fromSeed(tokens.seedSecondary)

        val tertiaryPalette =
            PrismixTonalGenerator.fromSeed(tokens.seedTertiary)

        val isDark = tokens.isDark

        val baseScheme = PrismixColorScheme(
            primary = if (isDark) primaryPalette[80] else primaryPalette[40],
            onPrimary = if (isDark) primaryPalette[20] else primaryPalette[100],
            primaryContainer = if (isDark) primaryPalette[30] else primaryPalette[90],
            onPrimaryContainer = if (isDark) primaryPalette[90] else primaryPalette[10],

            secondary = if (isDark) secondaryPalette[80] else secondaryPalette[40],
            onSecondary = if (isDark) secondaryPalette[20] else secondaryPalette[100],
            secondaryContainer = if (isDark) secondaryPalette[30] else secondaryPalette[90],
            onSecondaryContainer = if (isDark) secondaryPalette[90] else secondaryPalette[10],

            tertiary = if (isDark) tertiaryPalette[80] else tertiaryPalette[40],
            onTertiary = if (isDark) tertiaryPalette[20] else tertiaryPalette[100],
            tertiaryContainer = if (isDark) tertiaryPalette[30] else tertiaryPalette[90],
            onTertiaryContainer = if (isDark) tertiaryPalette[90] else tertiaryPalette[10],

            background = if (isDark) 0xFF121212 else 0xFFFFFFFF,
            onBackground = if (isDark) 0xFFFFFFFF else 0xFF000000,

            surface = if (isDark) primaryPalette[20] else primaryPalette[99],
            onSurface = if (isDark) primaryPalette[90] else primaryPalette[10],

            surfaceVariant = primaryPalette[90],
            onSurfaceVariant = primaryPalette[30],

            outline = primaryPalette[50],
            error = 0xFFB00020,
            onError = 0xFFFFFFFF,

            inverseSurface = if (isDark) 0xFFFFFFFF else 0xFF121212,
            inverseOnSurface = if (isDark) 0xFF000000 else 0xFFFFFFFF,
            inversePrimary = primaryPalette[40]
        )

        // Apply overrides jika ada
        return overrides?.let { o ->
            baseScheme.copy(
                primary = o.primary ?: baseScheme.primary,
                onPrimary = o.onPrimary ?: baseScheme.onPrimary,
                secondary = o.secondary ?: baseScheme.secondary,
                onSecondary = o.onSecondary ?: baseScheme.onSecondary,
                background = o.background ?: baseScheme.background,
                surface = o.surface ?: baseScheme.surface,
                error = o.error ?: baseScheme.error
            )
        } ?: baseScheme
    }
}
