package io.github.hasanelfalakiy.prismix.core.color

object PrismixTonalGenerator {

    fun fromSeed(seed: Long): PrismixTonalPalette {
        val hsl = LongColorUtils.toHSL(seed)

        val tones = listOf(
            0,10,20,30,40,50,60,70,80,90,95,99,100
        ).associateWith { tone ->
            LongColorUtils.fromHSL(
                hsl[0],
                hsl[1],
                tone / 100f
            )
        }

        return PrismixTonalPalette(tones)
    }
}
