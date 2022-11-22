package com.astermind.upet_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.astermind.upet_mobile.adapters.CardAdapter
//import com.astermind.upet_mobile.data.MascotasDataBase
import com.astermind.upet_mobile.databinding.ActivityHomeScreenBinding
import com.astermind.upet_mobile.models.*
import com.astermind.upet_mobile.services.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeScreen : AppCompatActivity(), MascotaClickListener {
    private lateinit var binding: ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val cUsuarioHome = findViewById<ImageView>(R.id.gUsuarioHome)

        val homeScreen = this

        cUsuarioHome.setOnClickListener() {
            goToPerfil()
        }
   getMascotas(homeScreen)



    }


    private fun getMascotas(view: HomeScreen){


        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://upetapi.azurewebsites.net/api/")
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getDataMascotas()

        retrofitData.enqueue(object : Callback<List<PetItem>?> {
            override fun onResponse(
                call: Call<List<PetItem>?>,
                response: Response<List<PetItem>?>
            ) {
                val responseBody = response.body()!!


               lMas = responseBody.toMutableList()



            try{
                binding.gRecyclerView.apply {
                    layoutManager=LinearLayoutManager(applicationContext)
                    adapter=CardAdapter(lMas, view)


                }
              }catch (e: Exception){
                Log.d("ERROR: ", "----------------------------------------" +e.message)

            }
            }

            override fun onFailure(call: Call<List<PetItem>?>, t: Throwable) {
                Log.d("Error:" ,"Fallo en: " + t.message)


            }
        })


    }

    private fun goToPerfil() {
        val i = Intent(this, UserScreen::class.java)
        startActivity(i)
    }

    override fun onClick(mascota: PetItem) {
        val intent = Intent(this, DogsScreen::class.java)
        intent.putExtra(MASCOTA_ID_EXTRA, mascota.id)
        startActivity(intent)
    }

    private fun upetMascotas(lstMascota: Mascota){
        /*val mascota1 = Mascota(
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

        mascotaList.add(mascota1)*/


    }
}