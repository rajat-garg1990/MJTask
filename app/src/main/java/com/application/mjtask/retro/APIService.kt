package com.application.mjtask.retro

import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("search?term=Michael+jackson&entity=song")
    fun getTracks(): Call<AudioResponse>
}