package com.example.week1202retrofit

import retrofit2.http.GET

interface LolApi {
    @GET("champion")
    suspend fun getChampions(): List<Champion>
}