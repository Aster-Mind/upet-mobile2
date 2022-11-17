package com.astermind.upet_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.*
import com.google.android.material.textfield.TextInputLayout

class AddScreen : AppCompatActivity() {


    val pickMedia = registerForActivityResult(PickVisualMedia()) { uri ->
        if (uri != null) {
            cImagenSubida.setImageURI(uri)
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_screen)

        cSubirFoto = findViewById(R.id.gSubirFoto)
        cImagenSubida = findViewById(R.id.gImagenSubida)

        cSubirFoto.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
        }

        val autocomp = findViewById<AutoCompleteTextView>(R.id.auto_complete_txt)
        val autocompMun = findViewById<AutoCompleteTextView>(R.id.auto_complete_municipio)
        val adapterArray = ArrayAdapter(this, R.layout.list_item, generos)
        val adapterMun = ArrayAdapter(this, R.layout.list_item, municipios)
        cAgregarNueva = findViewById(R.id.gAgregarNueva)

        autocomp.setAdapter(adapterArray)
        autocompMun.setAdapter(adapterMun)
        autocomp.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position).toString()
            Toast.makeText(applicationContext, "Genero: $item", Toast.LENGTH_SHORT).show()
        })
        autocompMun.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            val itemMun = parent.getItemAtPosition(position).toString()
            Toast.makeText(applicationContext, "Municipio: $itemMun", Toast.LENGTH_SHORT).show()
        })

        cAgregarNueva.setOnClickListener() {
           //goToUsuario()
            Toast.makeText(this, "Agregado correctamente", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun goToUsuario() {
        val i = Intent(this, UserScreen::class.java)
        startActivity(i)
    }

}