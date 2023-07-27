package com.example.appenglish.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appenglish.repository.AudioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AudioViewModel @Inject constructor(private val audioRepository: AudioRepository) : ViewModel() {

    var timeDuration = audioRepository.getTimeLiveData();

    fun playAudio() {
        viewModelScope.launch {
            audioRepository.playAudio()
        }
    }

    fun getTotalTime(path: String){
        viewModelScope.launch {
            audioRepository.getTotalTimeAudio(path)
        }
    }
}