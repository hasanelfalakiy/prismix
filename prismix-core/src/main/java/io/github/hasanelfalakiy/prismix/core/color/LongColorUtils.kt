package io.github.hasanelfalakiy.prismix.core.color

import kotlin.math.*

object LongColorUtils {

    // =============================
    // ARGB Long → HSL
    // =============================
    fun toHSL(color: Long): FloatArray {

        val r = ((color shr 16) and 0xFF).toFloat() / 255f
        val g = ((color shr 8) and 0xFF).toFloat() / 255f
        val b = (color and 0xFF).toFloat() / 255f

        val max = maxOf(r, g, b)
        val min = minOf(r, g, b)
        val delta = max - min

        val l = (max + min) / 2f

        val s = if (delta == 0f) {
            0f
        } else {
            delta / (1f - abs(2f * l - 1f))
        }

        val h = when {
            delta == 0f -> 0f
            max == r -> 60f * (((g - b) / delta) % 6f)
            max == g -> 60f * (((b - r) / delta) + 2f)
            else -> 60f * (((r - g) / delta) + 4f)
        }

        val hue = if (h < 0f) h + 360f else h

        return floatArrayOf(hue, s, l)
    }

    // =============================
    // HSL → ARGB Long
    // =============================
    fun fromHSL(h: Float, s: Float, l: Float, alpha: Int = 255): Long {

        val c = (1f - abs(2f * l - 1f)) * s
        val x = c * (1f - abs((h / 60f) % 2f - 1f))
        val m = l - c / 2f

        val (r1, g1, b1) = when {
            h < 60f  -> Triple(c, x, 0f)
            h < 120f -> Triple(x, c, 0f)
            h < 180f -> Triple(0f, c, x)
            h < 240f -> Triple(0f, x, c)
            h < 300f -> Triple(x, 0f, c)
            else     -> Triple(c, 0f, x)
        }

        val r = ((r1 + m) * 255f).roundToInt().coerceIn(0, 255)
        val g = ((g1 + m) * 255f).roundToInt().coerceIn(0, 255)
        val b = ((b1 + m) * 255f).roundToInt().coerceIn(0, 255)

        return ((alpha.toLong() and 0xFFL) shl 24) or
                ((r.toLong() and 0xFFL) shl 16) or
                ((g.toLong() and 0xFFL) shl 8) or
                (b.toLong() and 0xFFL)
    }

    // =============================
    // Utility helpers
    // =============================

    fun getAlpha(color: Long): Int =
        ((color shr 24) and 0xFF).toInt()

    fun getRed(color: Long): Int =
        ((color shr 16) and 0xFF).toInt()

    fun getGreen(color: Long): Int =
        ((color shr 8) and 0xFF).toInt()

    fun getBlue(color: Long): Int =
        (color and 0xFF).toInt()
}
