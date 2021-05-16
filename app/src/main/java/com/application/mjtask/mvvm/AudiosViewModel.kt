package com.application.mjtask.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.application.mjtask.retro.AudioResponse

class AudiosViewModel() : ViewModel() {
    var audiosRepository = AudiosRepository()
    var audioTracks: LiveData<AudioResponse> = audiosRepository.tracks

    fun getTracks() {
        audiosRepository.getTracks()
    }
}