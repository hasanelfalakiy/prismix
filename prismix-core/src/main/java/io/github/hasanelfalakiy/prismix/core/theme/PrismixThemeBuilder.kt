package io.github.hasanelfalakiy.prismix.core.theme

import io.github.hasanelfalakiy.prismix.core.color.*
import io.github.hasanelfalakiy.prismix.core.token.PrismixColorTokens

class PrismixThemeBuilder {

    private var tokens: PrismixColorTokens? = null
    private var overrides: PrismixColorOverrides? = null

    fun seed(
        primary: Long,
        secondary: Long,
        tertiary: Long,
        isDark: Boolean
    ) = apply {
        tokens = PrismixColorTokens(
            seedPrimary = primary,
            seedSecondary = secondary,
            seedTertiary = tertiary,
            isDark = isDark
        )
    }

    fun overrides(block: PrismixColorOverrides.() -> PrismixColorOverrides) = apply {
        overrides = PrismixColorOverrides().block()
    }

    fun build(): PrismixTheme {
        val t = tokens ?: error("Seed must be provided")

        val scheme = PrismixSchemeFactory.create(t, overrides)

        return PrismixTheme(
            colorScheme = scheme,
            isDark = t.isDark
        )
    }
}
