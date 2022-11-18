package com.astermind.upet_mobile.models

var duenoList = mutableListOf<Dueno>()

val DUENO_ID_EXTRA = "duenoExtra"

class Dueno(
    var idDueno: Int? = duenoList.size,
    var imagen: Int,
    var nombre: String,
    var correo: String,
    var telefono: String,
    var historia: String
)