package com.example.appenglish.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appenglish.model.Lesson
import com.example.appenglish.model.Timer

interface AudioRepository {


    suspend fun getAllAudio(): MutableLiveData<List<Lesson>>

    suspend fun playAudio()
    suspend fun pauseAudio()
    suspend fun stopAudio()
    suspend fun getTotalTimeAudio(path: String)
    fun getTimeLiveData(): LiveData<Timer>

}