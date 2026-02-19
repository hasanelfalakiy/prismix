package io.github.hasanelfalakiy.prismix.compose

import androidx.compose.runtime.staticCompositionLocalOf
import io.github.hasanelfalakiy.prismix.core.model.PrismixTheme

val LocalPrismixTheme = staticCompositionLocalOf<PrismixTheme> {
    error("PrismixTheme not provided")
}
