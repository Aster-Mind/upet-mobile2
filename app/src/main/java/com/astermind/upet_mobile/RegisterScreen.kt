package com.astermind.upet_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class RegisterScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)

        // Codigo para pantalla completa
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        // Declaracion de componentes / Navegacion TODO
        //val cUsernameR = findViewById<TextInputLayout>(R.id.outlinedUsernameR)
        //val cEmailR = findViewById<TextInputLayout>(R.id.outlinedEmailR)
        //val cPasswordR = findViewById<TextInputLayout>(R.id.outlinedPasswordR)
        val cBtnRegistrarse = findViewById<Button>(R.id.gButtonRegister)
        cBtnRegistrarse.setOnClickListener {
            Register()
        }

    }

    // Funciones de navegacion
    private fun Register(){
        val i = Intent(this, HomeScreen::class.java)
        startActivity(i)
    }
}