package com.example.appenglish.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appenglish.R
import com.example.appenglish.databinding.ActivityDetailsAudioTrackBinding

class DetailsAudioTrackActivity : AppCompatActivity() {

    var binding: ActivityDetailsAudioTrackBinding ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsAudioTrackBinding.inflate(layoutInflater)
        setContentView(binding?.root)


    }
}