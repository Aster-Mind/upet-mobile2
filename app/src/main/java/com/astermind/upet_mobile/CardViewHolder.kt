package com.astermind.upet_mobile

import android.graphics.BitmapFactory
import android.graphics.Color
import android.util.Base64
import androidx.recyclerview.widget.RecyclerView
import com.astermind.upet_mobile.databinding.CardPetsBinding
import com.astermind.upet_mobile.models.Mascota
import com.astermind.upet_mobile.models.PetItem

class CardViewHolder(
    private val cardPetsBinding: CardPetsBinding,
    private val clickListener: MascotaClickListener
) : RecyclerView.ViewHolder(cardPetsBinding.root) {
    fun bindMascota(mascota: PetItem) {

        if(mascota.imagen != null) {
            val imageBytes = Base64.decode(mascota.imagen, Base64.DEFAULT)
            val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            cardPetsBinding.gCardImagePet.setImageBitmap(decodedImage)
        }

if(mascota.duenoFoto != null){
        val imageBytesD = Base64.decode(mascota.duenoFoto, Base64.DEFAULT)
        val decodedImageD = BitmapFactory.decodeByteArray(imageBytesD, 0, imageBytesD.size)
        cardPetsBinding.gCardImageOwner.setImageBitmap(decodedImageD)
}

        cardPetsBinding.gCardTextEdad.text = mascota.edad.toString()
        cardPetsBinding.gCardTextTipo.text = mascota.tipo
        cardPetsBinding.gCardTextRaza.text = mascota.raza
        cardPetsBinding.gCardTextUbicacion.text = mascota.ubicacion
        cardPetsBinding.gCardTextGenero.text = mascota.genero
        cardPetsBinding.gCardTextNombre.text = mascota.nombre
        if (mascota.genero == "Macho") {
            cardPetsBinding.gCardCardGenero.setCardBackgroundColor(Color.parseColor("#26006AF6"))
            cardPetsBinding.gCardTextGenero.setTextColor(Color.parseColor("#0045A2"))
        } else {
            cardPetsBinding.gCardCardGenero.setCardBackgroundColor(Color.parseColor("#26EB5757"))
            cardPetsBinding.gCardTextGenero.setTextColor(Color.parseColor("#973939"))
        }
        cardPetsBinding.cardPets.setOnClickListener {
            clickListener.onClick(mascota)
        }
    }
}