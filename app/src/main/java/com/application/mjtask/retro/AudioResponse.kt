package com.application.mjtask.retro

import java.io.Serializable

data class AudioResponse(var results: ArrayList<AudioTracks>)

data class AudioTracks(
    val artistName: String,
    val collectionName: String,
    val trackName: String,
    val collectionViewUrl:String,
    val previewUrl: String,
    val artworkUrl100:String,
    val releaseDate:String,
    val discNumber:Int,
    val trackNumber:Int,
    val trackTimeMillis:Long,
    val country:String,
    val primaryGenreName:String
) : Serializable
