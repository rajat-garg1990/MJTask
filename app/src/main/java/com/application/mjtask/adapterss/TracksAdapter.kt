package com.application.mjtask.adapterss

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.application.mjtask.R
import com.application.mjtask.TrackDetailsActivity
import com.application.mjtask.retro.AudioTracks
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class TracksAdapter(var context: Context) :RecyclerView.Adapter<TracksAdapter.ViewHolder>() {
    class ViewHolder(view: View) :RecyclerView.ViewHolder(view) {
        var image=view.findViewById<ImageView>(R.id.audioImage)
        var title=view.findViewById<TextView>(R.id.audioTitle)
        var artist=view.findViewById<TextView>(R.id.audioArtist)
        var collection=view.findViewById<TextView>(R.id.audioCollection)
        var date=view.findViewById<TextView>(R.id.audioDate)
        var card=view.findViewById<CardView>(R.id.audioCard)
    }

    private var list: List<AudioTracks> = ArrayList()

    fun getUsers(list: ArrayList<AudioTracks>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item,parent,false))
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.artist.text=list[position].artistName
        holder.collection.text=list[position].collectionName
        holder.title.text=list[position].trackName
        Picasso.get().load(list[position].artworkUrl100).into(holder.image)
        holder.date.text= list[position].releaseDate.take(4)
        holder.card.setOnClickListener {
            var intent=Intent(context,TrackDetailsActivity::class.java)
            intent.putExtra("track",list[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}