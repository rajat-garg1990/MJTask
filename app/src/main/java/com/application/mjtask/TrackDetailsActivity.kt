package com.application.mjtask

import android.annotation.SuppressLint
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.application.mjtask.retro.AudioTracks
import com.squareup.picasso.Picasso
import java.util.concurrent.TimeUnit

@Suppress("DEPRECATION")
class TrackDetailsActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track_details)

        var trackInfo= intent.extras!!.get("track") as AudioTracks
        var image=findViewById<ImageView>(R.id.detailsImage)
        var title=findViewById<TextView>(R.id.detailsTitle)
        var artist=findViewById<TextView>(R.id.detailsArtist)
        var collection=findViewById<TextView>(R.id.detailsCollection)
        var disc=findViewById<TextView>(R.id.detailsDisc)
        var track=findViewById<TextView>(R.id.detailsTrack)
        var released=findViewById<TextView>(R.id.detailsRelease)
        var runtime=findViewById<TextView>(R.id.detailsRuntime)
        var country=findViewById<TextView>(R.id.detailsCountry)
        var genre=findViewById<TextView>(R.id.detailsGenre)
        var collectionButton=findViewById<Button>(R.id.collectionButton)
        var playButton=findViewById<ImageButton>(R.id.playButton)

        Picasso.get().load(trackInfo.artworkUrl100).into(image)
        title.text=trackInfo.trackName
        artist.text=trackInfo.artistName
        collection.text=trackInfo.collectionName
        disc.text=trackInfo.discNumber.toString()
        track.text=trackInfo.trackNumber.toString()
        released.text=trackInfo.releaseDate.take(4)
        runtime.text=TimeUnit.MILLISECONDS.toMinutes(trackInfo.trackTimeMillis).toString()+" minute(s)"
        country.text=trackInfo.country
        genre.text=trackInfo.primaryGenreName
        collectionButton.setOnClickListener{
            var intent=Intent(this,ViewCollectionActivity::class.java)
            intent.putExtra("link",trackInfo.collectionViewUrl)
            startActivity(intent)
        }
        var mp = MediaPlayer()
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC)
        mp.setDataSource(trackInfo.previewUrl)
        mp.prepare()
        playButton.setOnClickListener {
            if(mp.isPlaying)
                mp.stop()
            else
                mp.start()
        }
    }
}