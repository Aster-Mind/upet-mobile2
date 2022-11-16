package com.astermind.upet_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.astermind.upet_mobile.databinding.ActivityHomeScreenBinding

class HomeScreen : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        val cUsuarioHome = findViewById<ImageView>(R.id.gUsuarioHome)
        cUsuarioHome.setOnClickListener() {
            goToPerfil()
        }
    }


    private fun goToPerfil() {
        val i = Intent(this, UserScreen::class.java)
        startActivity(i)
    }

    private fun initRecyclerView(){
        binding.gCartasMascotas.layoutManager = LinearLayoutManager(this)
        binding.gCartasMascotas.adapter = MascotasAdapter(MascotasProvider.mascotasList)
    }
}