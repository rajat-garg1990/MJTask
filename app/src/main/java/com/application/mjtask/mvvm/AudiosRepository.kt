package com.application.mjtask.mvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.application.mjtask.retro.APIService
import com.application.mjtask.retro.AudioResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AudiosRepository() {
    private var baseURL = "https://itunes.apple.com/"
    var tracks = MutableLiveData<AudioResponse>()

    private val retro = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private var service = retro.create(APIService::class.java)

    fun getTracks() {
        service.getTracks().enqueue(object : Callback<AudioResponse> {
            override fun onResponse(call: Call<AudioResponse>, response: Response<AudioResponse>) {
                tracks.value=response.body()
                Log.d("Main","W")
            }

            override fun onFailure(call: Call<AudioResponse>, t: Throwable) {
                Log.d("Main","F")
            }
        })
    }
}