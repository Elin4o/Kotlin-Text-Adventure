package com.example.kotlinadventure

import android.content.Intent
import android.content.res.Configuration
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Switch
import android.widget.ToggleButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.button.MaterialButtonToggleGroup
import kotlinx.android.synthetic.main.activity_title_screen.*

class TitleScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title_screen)

        val toggleButton = findViewById<ToggleButton>(R.id.toggleButton)

        toggleButton.setOnClickListener{
            val isNightTheme = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK

            when(isNightTheme){
                Configuration.UI_MODE_NIGHT_NO->AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

                Configuration.UI_MODE_NIGHT_YES->AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

    }
        fun switchToGameScreen(view: View?) {
            val gameScreen = Intent(this, GameScreen::class.java)
            startActivity(gameScreen)
        }

        fun switchToInfoScreen(view: View?) {
            val infoActivity = Intent(this, InfoActivity::class.java)
            startActivity(infoActivity)
        }
    }

