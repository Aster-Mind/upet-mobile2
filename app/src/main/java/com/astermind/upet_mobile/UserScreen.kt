package com.astermind.upet_mobile

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.astermind.upet_mobile.models.thisSession

class UserScreen : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
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

        val nombre = findViewById<TextView>(R.id.gUsuarioPerfil)
        val mun = findViewById<TextView>(R.id.gMunicipio)
        val corr = findViewById<TextView>(R.id.gCorreoUsuario)
        val tel = findViewById<TextView>(R.id.gTelefono)
        val img = findViewById<ImageView>(R.id. gImagenUsuario)
        val imageBytes = Base64.decode(thisSession.imagen, Base64.DEFAULT)
        val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)

       img.setImageBitmap(decodedImage)
        nombre.text = thisSession.nombre
        mun.text = thisSession.municipio
        corr.text = thisSession.correo
        tel.text = thisSession.telefono
    }

    private fun goToAdd() {
        val i = Intent(this, AddScreen::class.java)
        startActivity(i)
    }
}
