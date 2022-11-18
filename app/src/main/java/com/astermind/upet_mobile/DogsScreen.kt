package com.astermind.upet_mobile

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.astermind.upet_mobile.databinding.ActivityDogsScreenBinding
import com.astermind.upet_mobile.models.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DogsScreen : AppCompatActivity() {
    private lateinit var binding: ActivityDogsScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogsScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        val mascotaID = intent.getIntExtra(MASCOTA_ID_EXTRA, -1)
        val mascota = mascotaFromID(mascotaID)
        if (mascota != null) {
            binding.gDetailFoto.setImageResource(mascota.imagen)
            binding.gDetailNombre.text = mascota.nombre
            binding.gDetailColor.text = mascota.colorMascota
            binding.gDetailGenero.text = mascota.genero
            binding.gDetailUbicacion.text = mascota.ubicacion
            binding.gDetailTipo.text = mascota.tipo
            binding.gDetailRaza.text = mascota.raza
            binding.gDetailDescripcion.text = mascota.historia
            binding.gDetailEdad.text = mascota.edad.toString()
            binding.gDetailColor.text = mascota.colorMascota
            binding.gDetailPeso.text = mascota.peso
            binding.gDetailDueno.setImageResource(mascota.duenoFoto)
            binding.gDetailNombreDueno.text=mascota.duenoNombre
        }

        val url = "\"https://api.whatsapp.com/send?phone=\"+number;"
        binding.gBotonAdoptar.setOnClickListener(){
            val uri = Uri.parse("smsto"+"+523314159474")
            val intent = Intent(Intent.ACTION_VIEW,uri)
            intent.setPackage("com.whatsapp")
            if (intent.resolveActivity(this.packageManager)!=null){
                startActivity(intent)
            }else{
                Toast.makeText(this, "Whatsapp no esta instalado", Toast.LENGTH_SHORT).show()
            }

        }

//        val cBotonAdoptar = findViewById<FloatingActionButton>(R.id.gBotonAdoptar)
//        cBotonAdoptar.setOnClickListener() {
//            try {
//                val i = Intent().apply {
//                    action = Intent.ACTION_SEND
//                    putExtra(Intent.EXTRA_TEXT, "Hola ")
//                    putExtra("jid", "523326627948@s.whatsapp.net")
//                    type = "text/plain"
//                    setPackage("com.whatsapp")
//                }
//                startActivity(i)
//            } catch (e: Exception) {
//                e.printStackTrace()
//                val appPackageName = "com.whatsapp"
//                try {
//                    startActivity(
//                        Intent(
//                            Intent.ACTION_VIEW,
//                            Uri.parse("market://details?id=$appPackageName")
//                        )
//                    )
//                } catch (e: android.content.ActivityNotFoundException) {
//                    startActivity(
//                        Intent(
//                            Intent.ACTION_VIEW,
//                            Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
//                        )
//                    )
//                }
//            }
//        }
    }


    private fun mascotaFromID(mascotaID: Int): Mascota? {
        for (mascota in mascotaList) {
            if (mascota.idMascota == mascotaID)
                return mascota
        }
        return null
    }
}