package com.astermind.upet_mobile

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DashBoardScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board_screen)

        var btn = findViewById<Button>(R.id.buttonVerM)

        btn.setOnClickListener{
            goToPerfil()
        }
    }
    fun goToPerfil() {
        val i = Intent(this, UserScreen::class.java)
        startActivity(i)
    }
}