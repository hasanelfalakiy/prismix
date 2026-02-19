package io.github.hasanelfalakiy.prismix.core.color

data class PrismixColorScheme(
    val primary: Long,
    val onPrimary: Long,
    val primaryContainer: Long,
    val onPrimaryContainer: Long,

    val secondary: Long,
    val onSecondary: Long,
    val secondaryContainer: Long,
    val onSecondaryContainer: Long,

    val tertiary: Long,
    val onTertiary: Long,
    val tertiaryContainer: Long,
    val onTertiaryContainer: Long,

    val background: Long,
    val onBackground: Long,

    val surface: Long,
    val onSurface: Long,
    val surfaceVariant: Long,
    val onSurfaceVariant: Long,

    val outline: Long,
    val error: Long,
    val onError: Long,

    val inverseSurface: Long,
    val inverseOnSurface: Long,
    val inversePrimary: Long
)
