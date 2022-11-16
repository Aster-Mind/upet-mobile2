package com.astermind.upet_mobile

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.astermind.upet_mobile.databinding.SampleCardDogsBinding

class MascotasViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = SampleCardDogsBinding.bind(view)

    fun render(mascota: Mascota){
        binding.gCardNombre.text = mascota.nombreMascotaL
        binding.gCardEdad.text = mascota.edadMascotaL.toString()
        binding.gCardMunicipio.text = mascota.municipioMascotaL
        binding.gCardMascota.setImageResource(mascota.fotoMascotaL)
        binding.gCardOwner.setImageResource(mascota.fotoOwnerL)
    }

}