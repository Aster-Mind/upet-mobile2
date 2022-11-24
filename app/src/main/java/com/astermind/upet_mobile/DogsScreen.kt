package com.astermind.upet_mobile

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.astermind.upet_mobile.adapters.CardAdapter
import com.astermind.upet_mobile.databinding.ActivityDogsScreenBinding
import com.astermind.upet_mobile.models.*
import com.astermind.upet_mobile.services.ApiInterface
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
           // binding.gDetailFoto.setImageResource(mascota.imagen)
            binding.gDetailNombre.text = mascota.nombre
            binding.gDetailColor.text = mascota.color
            binding.gDetailGenero.text = mascota.genero
            binding.gDetailUbicacion.text = mascota.ubicacion
            binding.gDetailTipo.text = mascota.tipo
            binding.gDetailRaza.text = mascota.raza
            binding.gDetailDescripcion.text = mascota.historia
            binding.gDetailEdad.text = mascota.edad.toString()
            binding.gDetailColor.text = mascota.color
            binding.gDetailPeso.text = mascota.peso


            val imageBytes = Base64.decode(mascota.imagen, Base64.DEFAULT)
            val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)

            val imageBytes2 = Base64.decode(mascota.duenoFoto, Base64.DEFAULT)
            val decodedImage2 = BitmapFactory.decodeByteArray(imageBytes2, 0, imageBytes2.size)

           binding.gDetailFoto.setImageBitmap(decodedImage)
            binding.gDetailDueno.setImageBitmap(decodedImage2)
            binding.gDetailNombreDueno.text=mascota.duenoNombre

        }else{
            binding.gDetailNombre.text ="No Hay"
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


    private fun mascotaFromID(mascotaID: Int): PetItem? {
        /*  for (mascota in mascotaList) {
            if (mascota.idMascota == mascotaID)
                 return mascota
         }
         return null*/

        for(ms in lMas){
            if(ms.id == mascotaID){
                return ms
            }

        }

        return null
    }

    private fun GetMascota(mascotaID: Int): PetItem? {

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://upetapi.azurewebsites.net/api/")
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getDataMascota()

        retrofitData.enqueue(object : Callback<PetItem> {
            override fun onResponse(
                call: Call<PetItem>?,
                response: Response<PetItem>?
            ) {
                val responseBody = response!!.body()

              var mascota1  = PetItem(
                    responseBody!!.adoptado,
                    responseBody!!.color,
                    responseBody!!.duenoFoto,
                    responseBody!!.duenoHistoria,
                    responseBody!!.duenoNombre,
                    responseBody!!.edad,
                    responseBody!!.historia,
                    responseBody!!.id,
                    responseBody!!.imagen,
                    responseBody!!.nombre,
                    responseBody!!.peso,
                    responseBody!!.raza,
                    responseBody!!.tipo,
                    responseBody!!.ubicacion,
                    responseBody!!.genero,

                )



              Log.d("asd","----------------------------------------------"+ responseBody)
            }
            override fun onFailure(call: Call<PetItem>?, t: Throwable) {
                Log.d("Error:" ,"Fallo en: " + t.message)


            }
        })


return null
    }


}