package com.andihasan.prismix

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.andihasan.prismix.databinding.ActivityMainBinding
import io.github.hasanelfalakiy.prismix.core.color.PrismixSchemeFactory
import io.github.hasanelfalakiy.prismix.core.manager.PrismixThemeManager
import io.github.hasanelfalakiy.prismix.core.theme.PrismixTheme
import io.github.hasanelfalakiy.prismix.core.token.PrismixColorTokens
import io.github.hasanelfalakiy.prismix.xml.PrismixViewApplier

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Contoh penggunaan Library Prismix
        setupPrismixTheme()
    }

    private fun setupPrismixTheme() {
        // 1. Definisikan Token Warna (Seed Colors)
        val tokens = PrismixColorTokens(
            seedPrimary = 0xFF6750A4,    // Warna ungu
            seedSecondary = 0xFF625B71,  // Warna abu-abu
            seedTertiary = 0xFF7D5260,   // Warna merah muda
            isDark = false               // Mode terang
        )

        // 2. Buat ColorScheme dari Token
        val colorScheme = PrismixSchemeFactory.create(tokens)

        // 3. Buat Objek Theme
        val theme = PrismixTheme(
            colorScheme = colorScheme,
            isDark = tokens.isDark
        )

        // 4. Set Theme ke Manager
        PrismixThemeManager.setTheme(theme)

        // 5. Terapkan ke View (untuk XML/View System)
        PrismixViewApplier.apply(binding.root, theme)
    }
}