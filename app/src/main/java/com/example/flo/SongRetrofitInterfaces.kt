package com.example.flo

import retrofit2.Call
import retrofit2.http.GET

interface SongRetrofitInterfaces {
    @GET("/songs")
    fun getSongs(): Call<SongResponse>
}