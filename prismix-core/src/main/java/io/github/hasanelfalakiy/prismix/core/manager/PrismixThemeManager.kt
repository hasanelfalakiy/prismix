package io.github.hasanelfalakiy.prismix.core.manager

import io.github.hasanelfalakiy.prismix.core.model.PrismixTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object PrismixThemeManager {

    private val _theme = MutableStateFlow<PrismixTheme?>(null)
    val theme: StateFlow<PrismixTheme?> = _theme

    fun setTheme(theme: PrismixTheme) {
        _theme.value = theme
    }

    fun current(): PrismixTheme? = _theme.value
}
