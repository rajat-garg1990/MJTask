package com.application.mjtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.mjtask.adapterss.TracksAdapter
import com.application.mjtask.mvvm.AudiosViewModel

class MainActivity : AppCompatActivity() {
    lateinit var audioVM: AudiosViewModel
    lateinit var rAdapter: TracksAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recycler=findViewById<RecyclerView>(R.id.MJ_rv)
        audioVM = ViewModelProvider(this).get(AudiosViewModel::class.java)
        audioVM.getTracks()
        audioVM.audioTracks.observe(this, Observer {
            rAdapter.getUsers(it.results)
        })
        rAdapter= TracksAdapter(this)
        recycler.apply {
            adapter=rAdapter
            layoutManager=LinearLayoutManager(this@MainActivity)
        }
    }
}