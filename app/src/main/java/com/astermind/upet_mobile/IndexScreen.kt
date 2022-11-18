package com.astermind.upet_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView

class IndexScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index_screen)
        // Codigo para pantalla completa
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        // Declaracion de componentes / Navegacion
        val cBtnIniciarSesion = findViewById<Button>(R.id.gBtnIniciarSesion)
        val cBtnRegistro = findViewById<TextView>(R.id.gBtnRegistrate)
        cBtnIniciarSesion.setOnClickListener {
            goToLogin()
        }
        cBtnRegistro.setOnClickListener {
            goToRegister()
        }
    }

    // Funciones de navegacion
    private fun goToLogin() {
        val i = Intent(this, LoginScreen::class.java)
        startActivity(i)
    }

    private fun goToRegister() {
        val i = Intent(this, RegisterScreen::class.java)
        startActivity(i)
    }


}