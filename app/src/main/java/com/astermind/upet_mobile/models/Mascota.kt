package com.astermind.upet_mobile.models

var mascotaList = mutableListOf<Mascota>()

val MASCOTA_ID_EXTRA = "mascotaExtra"

class Mascota(
    var idMascota: Int? = mascotaList.size,
    var imagen: Int,
    var nombre: String,
    var tipo: String,
    var raza: String,
    var genero: String,
    var ubicacion: String,
    var historia: String,
    var edad: Int,
    var colorMascota: String,
    var duenoFoto: Int,
    var duenoNombre: String,
    var duenoHistoria: String,
    var peso: String
)