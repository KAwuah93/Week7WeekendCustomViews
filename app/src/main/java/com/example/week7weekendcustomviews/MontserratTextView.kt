package com.example.week7weekendcustomviews

import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.widget.TextView
import androidx.annotation.RequiresApi

class MontserratTextView : TextView{

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0 )
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr) {
        Log.d("CustomView", "the inflate is working")
        applyCustomText(context!!)
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    private fun applyCustomText(context : Context){
        val fontFace = FontCache.getTypeface(context, "fonts/montserratblack.otf")

        setTypeface(fontFace)
    }
}