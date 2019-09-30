package com.example.week7weekendcustomviews

import android.content.Context
import android.graphics.Typeface

class FontCache {

    companion object{
        private val fontCache = HashMap<String, Typeface>()

        fun getTypeface(context: Context, fontName: String) : Typeface{

            var typeface = fontCache.get(fontName)
            if(typeface == null){
                typeface = Typeface.createFromAsset(context.assets , fontName)
                fontCache.put(fontName, typeface)
            }
            //null assurance
            return typeface!!
        }

    }
}