package com.astermind.upet_mobile.data

import com.astermind.upet_mobile.R
import com.astermind.upet_mobile.models.Dueno

class DuenosDataBase {
    companion object{
        val duenoList = listOf<Dueno>(
            Dueno(
                1,
                R.drawable.dueno1,
                "Camila",
                "camila123@soycamila.com",
                "3311111111",
                "Hola soy Camila"
            )
        )
    }
}