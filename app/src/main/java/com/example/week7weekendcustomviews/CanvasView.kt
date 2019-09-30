package com.example.week7weekendcustomviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import android.view.MotionEvent

class CanvasView : View, View.OnTouchListener{
    lateinit var tCanvas: Canvas
    lateinit var paint: Paint
    //test
    var corx = 0f
    var cory = 0f
    //List of circles
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        setOnTouchListener(this)
        //inits the paint brush for the onTouch event
        getReady()
        Log.d("Canvas", "constructor works")
    }
    //constructor for higher level
    @RequiresApi(Build.VERSION_CODES.O)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)


    override fun onTouch(view: View?, motionEvent: MotionEvent): Boolean {
        // Use this to draw on the Canvas, the other gestures aren't as reliable

            Log.d("Canvas" , " Touch event at ${motionEvent.x} , ${motionEvent.y}")
            //tCanvas.drawLine(startx, starty, endx, endy, paint)
            corx = motionEvent.x
            cory = motionEvent.y
            invalidate()
        return true
    }
    override fun onDraw(canvas: Canvas?) {
        Log.d("Canvas", "draw function works")
        this.tCanvas = canvas!!
        tCanvas.drawCircle(corx, cory, 20f, paint)
    }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
    private fun getReady(){
        paint = Paint()
        paint.color = Color.rgb(255, 153, 51)
        paint.strokeWidth = 50f
    }
}