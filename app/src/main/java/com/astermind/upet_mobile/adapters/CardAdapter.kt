package com.astermind.upet_mobile.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.astermind.upet_mobile.CardViewHolder
import com.astermind.upet_mobile.MascotaClickListener
import com.astermind.upet_mobile.databinding.CardPetsBinding
import com.astermind.upet_mobile.models.Mascota
import com.astermind.upet_mobile.models.PetItem

class CardAdapter(
    private val mascotas: List<PetItem>,
    private val clickListener: MascotaClickListener
    ) : RecyclerView.Adapter<CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding= CardPetsBinding.inflate(from, parent, false)
        return CardViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindMascota(mascotas[position])
    }

    override fun getItemCount(): Int = mascotas.size
}