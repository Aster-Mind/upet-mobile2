package com.astermind.upet_mobile

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.astermind.upet_mobile.databinding.CardPetsBinding
import com.astermind.upet_mobile.models.Mascota

class CardViewHolder(
    private val cardPetsBinding: CardPetsBinding,
    private val clickListener: MascotaClickListener
) : RecyclerView.ViewHolder(cardPetsBinding.root) {
    fun bindMascota(mascota: Mascota) {
        cardPetsBinding.gCardImagePet.setImageResource(mascota.imagen)
        cardPetsBinding.gCardImageOwner.setImageResource(mascota.duenoFoto)
        cardPetsBinding.gCardTextEdad.text = mascota.edad.toString()
        cardPetsBinding.gCardTextTipo.text = mascota.tipo
        cardPetsBinding.gCardTextRaza.text = mascota.raza
        cardPetsBinding.gCardTextUbicacion.text = mascota.ubicacion
        cardPetsBinding.gCardTextGenero.text = mascota.genero
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