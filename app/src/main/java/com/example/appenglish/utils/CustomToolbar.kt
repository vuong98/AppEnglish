package com.example.appenglish.utils

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.appenglish.databinding.CustomToolbarBinding

class CustomToolbar : ConstraintLayout {

    var binding: CustomToolbarBinding ?= null

    constructor(context: Context) : super(context){
        initLayout(context)
    }
    constructor(context: Context, attributeSet: AttributeSet?) : super(context,attributeSet){
        initLayout(context)
    }
    constructor(context: Context, attributeSet: AttributeSet?, defStyle: Int) : super(context,attributeSet,defStyle){
        initLayout(context)
    }

    private fun initLayout(context: Context){
        Log.d("kDebug", "Init")
        binding =  CustomToolbarBinding.inflate(LayoutInflater.from(context),this,true)

        binding?.apply {
            Log.d("kDebug", "Init 1")
            tvTitle.setTextColor(Color.BLUE)
            tvSubtitle.setTextColor(Color.BLUE)

            tvTitle.text = "ABC"
            tvSubtitle.text = "SUB ABC"
        }


    }
}