package com.example.kotlinadventure

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_game_screen.*

class GameScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)

        val story = Story(this)

        buttonChoice1.setOnClickListener {
            story.selectPosition(story.nextPosition1)
        }
        buttonChoice2.setOnClickListener {
            story.selectPosition(story.nextPosition2)
        }
        buttonChoice3.setOnClickListener {
            story.selectPosition(story.nextPosition3)
        }
        buttonChoice4.setOnClickListener {
            story.selectPosition(story.nextPosition4)
        }

        story.startingPoint()

    }
    fun goTitleScreen() {
        val titleScreen = Intent(this, TitleScreen::class.java)
        startActivity(titleScreen)
    }
}
