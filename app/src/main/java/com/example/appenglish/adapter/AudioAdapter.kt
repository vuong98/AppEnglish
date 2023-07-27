package com.example.appenglish.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appenglish.databinding.ItemAudioBinding
import com.example.appenglish.model.Lesson

class AudioAdapter(
    private var listAudioTrack: MutableList<Lesson>,
    private var onClickItem: (Lesson) -> Unit

) : RecyclerView.Adapter<AudioAdapter.AudioViewHolder>() {


    inner class AudioViewHolder(private val binding: ItemAudioBinding) : RecyclerView.ViewHolder(binding.root) {

        fun binding(lesson: Lesson) {

            binding.tvNameAudio.text = lesson.nameAudio
            binding.tvLevel.text = lesson.nameLevel
            binding.layoutItem.setOnClickListener {
                onClickItem.invoke(lesson)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        val view = ItemAudioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AudioViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listAudioTrack.size
    }

    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {
        val lesson = listAudioTrack[position]

        holder.binding(lesson)

    }
}