package io.github.hasanelfalakiy.prismix.core.color

data class PrismixTonalPalette(
    val tones: Map<Int, Long>
) {
    operator fun get(tone: Int): Long =
        tones[tone] ?: error("Tone $tone not found")
}
