package com.astermind.upet_mobile

import com.astermind.upet_mobile.models.Mascota
import com.astermind.upet_mobile.models.PetItem

interface MascotaClickListener {
    fun onClick(mascota: PetItem)
}