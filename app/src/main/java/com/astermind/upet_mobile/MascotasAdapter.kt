package com.astermind.upet_mobile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MascotasAdapter(private val mascotasList: List<Mascota>) : RecyclerView.Adapter<MascotasViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MascotasViewHolder(layoutInflater.inflate(R.layout.sample_card_dogs, parent, false))
    }

    override fun onBindViewHolder(holder: MascotasViewHolder, position: Int) {
        val item = mascotasList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = mascotasList.size
}