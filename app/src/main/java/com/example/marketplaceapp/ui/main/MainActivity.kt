package com.example.marketplaceapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marketplaceapp.R
import com.example.marketplaceapp.utils.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomView()
    }

    private fun setupBottomView() {
        val navView = findViewById<BottomNavigationView>(R.id.bottomNav)

        val navIds = listOf(
            R.navigation.home,
            R.navigation.favorites,
            R.navigation.divider,
            R.navigation.messages,
            R.navigation.profile
        )

        navView.setupWithNavController(
            navGraphIds = navIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.navView,
            intent = intent
        )
    }
}