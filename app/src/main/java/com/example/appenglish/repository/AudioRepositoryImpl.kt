package com.example.appenglish.repository

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appenglish.model.Lesson
import com.example.appenglish.model.Timer
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.math.min

class AudioRepositoryImpl @Inject constructor(@ApplicationContext private val context: Context): AudioRepository {

    var mediaPlaer: MediaPlayer ?= null

    private val _totalTimeLiveData: MutableLiveData<Timer> by lazy { MutableLiveData() }

    var totalTimeLiveData: LiveData<Timer> = _totalTimeLiveData

    override suspend fun getAllAudio(): MutableLiveData<List<Lesson>> {
        //firebaseStore.reference.child("Users").child("")

        return MutableLiveData();
    }

    override suspend fun playAudio() {
        mediaPlaer?.start()
    }


    private fun getTimerCurrent(timer:Int ): Timer {
        var tmpTimer = timer;

        var hour = (timer/3600000)
        tmpTimer -= hour*3600000
        var minutes = (tmpTimer/60000)
        tmpTimer -= minutes*60000
        var second = tmpTimer/1000;

        Log.d("kDebug", "hour=$hour - minutes= $minutes - second = $second")

        return Timer(hour,minutes,second)


    }

    override suspend fun pauseAudio() {
        mediaPlaer?.pause()
    }

    override suspend fun stopAudio() {
        mediaPlaer?.stop()
        mediaPlaer?.release()
        mediaPlaer = null
    }

    override suspend fun getTotalTimeAudio(path: String) {
        GlobalScope.launch {
            mediaPlaer = MediaPlayer.create(context, Uri.parse(path))
            _totalTimeLiveData.postValue(getTimerCurrent(mediaPlaer?.duration ?: 0))

        }
    }

    override fun getTimeLiveData(): LiveData<Timer> {
        return  totalTimeLiveData
    }
}