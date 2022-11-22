package com.astermind.upet_mobile

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.*
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.*
import androidx.appcompat.app.AppCompatActivity
import com.astermind.upet_mobile.models.PetItem
import com.astermind.upet_mobile.models.thisSession
import com.astermind.upet_mobile.services.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.ByteArrayOutputStream


class AddScreen : AppCompatActivity() {
    var img_str =""
    var imgUserMas = "Imagen"
    var item = "Macho"
    var itemMun = "Guadalajara"
    val pickMedia = registerForActivityResult(PickVisualMedia()) { uri ->
        if (uri != null) {
            cImagenSubida.setImageURI(uri)
            var iv1 = cImagenSubida
            iv1.buildDrawingCache()
            val bitmap = iv1.drawingCache

            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream)
            val image: ByteArray = stream.toByteArray()
            println("byte array:$image")

             img_str = Base64.encodeToString(image, 0)
            println("string:$img_str")

            Toast.makeText(this, "Imagen seleccionada", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Imagen no seleccionada", Toast.LENGTH_SHORT).show()
            Log.i("aris", "no seleccionado")
        }
    }


    lateinit var cSubirFoto: ImageButton
    lateinit var cImagenSubida: ImageView
    lateinit var cAgregarNueva: Button

    val generos = arrayOf("Macho", "Hembra")
    val municipios = arrayOf("Zapopan", "Guadalajara", "Tlaquepaque", "Tlajomulco de Zuñiga")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_screen)

        cSubirFoto = findViewById(R.id.gSubirFoto)
        cImagenSubida = findViewById(R.id.gImagenSubida)

        cSubirFoto.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
        }

        val nombre = findViewById<EditText>(R.id.gNombre)
        val historia = findViewById<EditText>(R.id.gHistoria)
        val edad = findViewById<EditText>(R.id.gEdad)
        val color = findViewById<EditText>(R.id.gColor)
        val peso = findViewById<EditText>(R.id.gPeso)
        val autocomp = findViewById<AutoCompleteTextView>(R.id.auto_complete_txt)
        val autocompMun = findViewById<AutoCompleteTextView>(R.id.auto_complete_municipio)
        val adapterArray = ArrayAdapter(this, R.layout.list_item, generos)
        val adapterMun = ArrayAdapter(this, R.layout.list_item, municipios)
        cAgregarNueva = findViewById(R.id.gAgregarNueva)

        if(thisSession.imagen != null || thisSession.imagen != ""){
            imgUserMas = thisSession.imagen
        }
        autocomp.setAdapter(adapterArray)
        autocompMun.setAdapter(adapterMun)
        autocomp.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
             item = parent.getItemAtPosition(position).toString()
            Toast.makeText(applicationContext, "Genero: $item", Toast.LENGTH_SHORT).show()
        })
        autocompMun.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            itemMun = parent.getItemAtPosition(position).toString()
            Toast.makeText(applicationContext, "Municipio: $itemMun", Toast.LENGTH_SHORT).show()
        })

        cAgregarNueva.setOnClickListener() {
            //goToUsuario()

            var edadInt = "0"
            if(edad.text.toString() != ""){
       edadInt = edad.text.toString()

            }
            val mascota = PetItem(

                false,
            color.text.toString(),
                imgUserMas,
           "Vacía",
            thisSession.nombre,
                edadInt.toInt(),
            historia.text.toString(),
            0,
                img_str,
            nombre.text.toString(),
            peso.text.toString(),
            "Doberman",
            "Perro",
                thisSession.municipio,
                item
            )


            CrearMascota(mascota, this)


        }
    }


    private fun CrearMascota(pet:PetItem, context: Context){

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://upetapi.azurewebsites.net/api/")
            .build()
            .create(ApiInterface::class.java)

        val ApiInterface = retrofitBuilder.postMascota(pet)

        ApiInterface.enqueue(object: Callback<PetItem> {

            override fun onFailure(call: Call<PetItem>, t: Throwable) {

                Toast.makeText(context, "No Se ha podido agregar", Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<PetItem>, response: Response<PetItem>) {
                val rsp = response.body()
                Toast.makeText(context, "Agregado correctamente", Toast.LENGTH_SHORT).show()
                finish()
            }
        })

    }

    private fun goToUsuario() {
        val i = Intent(this, UserScreen::class.java)
        startActivity(i)
    }

}