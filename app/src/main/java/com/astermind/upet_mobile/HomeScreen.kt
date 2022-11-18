package com.astermind.upet_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.astermind.upet_mobile.adapters.CardAdapter
import com.astermind.upet_mobile.data.DuenosDataBase
import com.astermind.upet_mobile.data.MascotasDataBase
import com.astermind.upet_mobile.databinding.ActivityHomeScreenBinding
import com.astermind.upet_mobile.models.*

class HomeScreen : AppCompatActivity(), MascotaClickListener {
    private lateinit var binding: ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val cUsuarioHome = findViewById<ImageView>(R.id.gUsuarioHome)
        cUsuarioHome.setOnClickListener() {
            goToPerfil()
        }
        upetMascotas()
        val homeScreen = this
        binding.gRecyclerView.apply {
            layoutManager=LinearLayoutManager(applicationContext)
            adapter=CardAdapter(mascotaList, homeScreen)
        }
    }

    private fun goToPerfil() {
        val i = Intent(this, UserScreen::class.java)
        startActivity(i)
    }

    override fun onClick(mascota: Mascota) {
        val intent = Intent(this, DogsScreen::class.java)
        intent.putExtra(MASCOTA_ID_EXTRA, mascota.idMascota)
        startActivity(intent)
    }

    private fun upetMascotas(){
        val mascota1 = Mascota(
            0,
            R.drawable.pet1,
            "Spyke",
            "Perro",
            "Husky",
            "Macho",
            "Zapopan",
            "Hola, yo soy Spyke y soy un Husky.",
            5,
            "Blanco",
            R.drawable.dueno1,
            "Camila",
            "Hola, soy Camila",
            "5.0",
        )
        mascotaList.add(mascota1)

        mascotaList.add(mascota1)
    }
}