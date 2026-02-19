package io.github.hasanelfalakiy.prismix.xml

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import io.github.hasanelfalakiy.prismix.core.manager.PrismixThemeManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

object PrismixViewObserver {

    fun bind(
        lifecycleOwner: LifecycleOwner,
        rootView: View
    ) {
        lifecycleOwner.lifecycleScope.launch {
            PrismixThemeManager.theme.collectLatest { theme ->
                theme?.let {
                    PrismixViewApplier.apply(rootView, it)
                }
            }
        }
    }
}
