package com.example.appenglish.ui

import android.media.AudioTrack
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appenglish.R
import com.example.appenglish.adapter.AudioAdapter
import com.example.appenglish.databinding.ActivityListAudioTrackBinding
import com.example.appenglish.model.Lesson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListAudioTrackActivity : AppCompatActivity() {

    var listAudioTrack = mutableListOf<Lesson>()

    var adapterAudioTrack: AudioAdapter ?= null

    var binding: ActivityListAudioTrackBinding ?= null

    private fun onClick(lesson: Lesson){


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListAudioTrackBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        adapterAudioTrack = AudioAdapter(listAudioTrack, ::onClick)

        binding?.apply {

            rcvTrackAudio.apply {
                hasFixedSize()
                layoutManager = LinearLayoutManager(this@ListAudioTrackActivity, RecyclerView.VERTICAL, false)
                adapter = adapterAudioTrack

            }

        }

    }
}