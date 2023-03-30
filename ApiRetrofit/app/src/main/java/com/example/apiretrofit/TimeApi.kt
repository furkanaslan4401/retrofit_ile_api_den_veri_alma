package com.example.apiretrofit

import retrofit2.Call
import retrofit2.http.GET

interface TimeApi {

    @GET("zone?timeZone=Europe/Istanbul")
    fun getData(): Call<GetApi>

}