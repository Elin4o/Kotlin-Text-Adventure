package com.example.kotlinadventure

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
    }
    fun switchToIntroScreen(view: View?) {
        val titleScreen = Intent(this, TitleScreen::class.java)
        startActivity(titleScreen)
    }
}