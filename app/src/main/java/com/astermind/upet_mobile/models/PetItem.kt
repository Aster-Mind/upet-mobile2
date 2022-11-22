package com.astermind.upet_mobile.models
var lMas = mutableListOf<PetItem>()
val MASCOTA_ID_EXTRA = "mascotaExtra"
data class PetItem(
    val adoptado: Boolean,
    val color: String,
    val duenoFoto: String,
    val duenoHistoria: String,
    val duenoNombre: String,
    val edad: Int,
    val historia: String,
    val id: Int,
    val imagen: String,
    val nombre: String,
    val peso: String,
    val raza: String,
    val tipo: String,
    val ubicacion: String,
    val genero: String
)