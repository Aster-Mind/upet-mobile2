package com.astermind.upet_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class UserScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_screen)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        val cAgregarMascota = findViewById<Button>(R.id.gAgregarMascota)
        cAgregarMascota.setOnClickListener() {
            goToAdd()
        }
    }

    private fun goToAdd() {
        val i = Intent(this, AddScreen::class.java)
        startActivity(i)
    }
}
