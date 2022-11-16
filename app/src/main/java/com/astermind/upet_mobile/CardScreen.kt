package com.astermind.upet_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class CardScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_screen)
        val cCartaMascota = findViewById<CardView>(R.id.gCartaMascota)
        cCartaMascota.setOnClickListener(){
            goToDogs()
        }
    }
    private fun goToDogs(){
        val i = Intent(this, DogsScreen::class.java)
        startActivity(i)
    }
}