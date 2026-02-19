package io.github.hasanelfalakiy.prismix.xml

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.github.hasanelfalakiy.prismix.core.model.PrismixTheme

object PrismixViewApplier {

    fun apply(view: View, theme: PrismixTheme) {
        when (view) {

            is TextView -> {
                view.setTextColor(theme.colors.onBackground.toInt())
            }

            else -> {
                view.setBackgroundColor(theme.colors.background.toInt())
            }
        }

        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                apply(view.getChildAt(i), theme)
            }
        }
    }
}
