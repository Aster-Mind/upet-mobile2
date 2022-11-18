package com.astermind.upet_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        // Codigo para pantalla completa
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )


        // Declaracion de componentes / Navegacion TODO
        //val Email = findViewById<TextInputLayout>(R.id.outlinedEmail)
        //val Password = findViewById<TextInputLayout>(R.id.outlinedPassword)
        val Login = findViewById<Button>(R.id.gButtonLogin)
        val Restablecer = findViewById<TextView>(R.id.gOlvide)
        Login.setOnClickListener {
            Login()
        }
        Restablecer.setOnClickListener {
            Restablecer()
        }

    }

    // Funciones de navegacion
    private fun Login() {
        val i = Intent(this, HomeScreen::class.java)
        startActivity(i)
    }

    private fun Restablecer() {
        val i = Intent(this, ForgotScreen::class.java)
        startActivity(i)
    }
}