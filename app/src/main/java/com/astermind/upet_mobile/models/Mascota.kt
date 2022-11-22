package com.astermind.upet_mobile.models

var mascotaList = mutableListOf<Mascota>()



class Mascota(
    var idMascota: Int,
    var imagen: String,
    var nombre: String,
    var tipo: String,
    var raza: String,
    var genero: String,
    var ubicacion: String,
    var historia: String,
    var edad: Int,
    var colorMascota: String,
    var duenoFoto: String,
    var duenoNombre: String,
    var duenoHistoria: String,
    var peso: String
)