package com.astermind.upet_mobile.helpers

import com.astermind.upet_mobile.services.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder() {

    fun RetrofitCons(){
    val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://upetapi.azurewebsites.net/api/")
        .build()
        .create(ApiInterface::class.java)

}
}