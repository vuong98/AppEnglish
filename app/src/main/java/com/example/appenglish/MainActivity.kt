package com.example.appenglish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.appenglish.databinding.ActivityMainBinding
import com.example.appenglish.viewmodel.AudioViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    var viewBindingMain: ActivityMainBinding?= null

    private val audioViewModel: AudioViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBindingMain = ActivityMainBinding.inflate(layoutInflater)

        setContentView(viewBindingMain?.root)

        audioViewModel.timeDuration.observe(this) {
            Log.d("kDebug","timer = $it")
            if (it.min != 0) {
                audioViewModel.playAudio()
            }
        }


        viewBindingMain?.apply {

            this.btnLogin.setOnClickListener {
                audioViewModel.getTotalTime("https://firebasestorage.googleapis.com/v0/b/flutter-3ce03.appspot.com/o/Alone%2C%20Pt.%20II%20-%20Alan%20Walker%2C%20Ava%20Max.mp3?alt=media&token=40a64468-f41c-4bbe-ab47-3e7f4ad92dc6")
            }
        }


    }
}