package com.example.week7weekendcustomviews

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.compoundmonserrat.view.*

class CompoundMonserrat : LinearLayout, View.OnClickListener {

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr) {
        Log.d("CMP", "The Inflate works for the compound")
        View.inflate(getContext(), R.layout.compoundmonserrat, this)

        btnTransform.setOnClickListener(this)
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun onClick(view: View?) {

        when(view?.id) {
               btnTransform.id -> {
                   Log.d("CMP", "OnClick working")

                   //setting the val to split
                   val split = etPreMont.text.toString()
                   etVanilla.text = split
                   etMonty.text = split
               }
        }
    }
}