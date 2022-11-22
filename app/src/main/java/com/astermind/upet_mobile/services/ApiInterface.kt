package com.astermind.upet_mobile.services


import com.astermind.upet_mobile.models.LoginCreds
import com.astermind.upet_mobile.models.Pet
import com.astermind.upet_mobile.models.PetItem
import com.astermind.upet_mobile.models.RolCreds
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("mascotas/get")
    fun getDataMascotas(): Call<List<PetItem>>

    @GET("mascotas/2")
    fun getDataMascota(): Call<PetItem>

    @POST("users/login/user")
    fun Login(
        @Body LoginCreds: LoginCreds
    ):Call<RolCreds>

    @POST("mascotas")
    fun postMascota(@Body mascota:PetItem):Call<PetItem>
}