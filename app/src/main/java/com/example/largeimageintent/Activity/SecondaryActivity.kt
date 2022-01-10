package com.example.largeimageintent.Activity

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.largeimageintent.R

class SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)
        title="secondary"

        var imageView=findViewById<ImageView>(R.id.iv)
        imageView.setImageBitmap(decodeSampleBitmapResource(getResources(), R.drawable.image,500,500))

    }

fun  sampleSize(options : BitmapFactory.Options,  a: Int, b:Int) : Int{
    var height=options.outHeight
    var width=options.outWidth
    var inSampleSize=1

    if(height>a||width>b){
        var halfHeight=height/2
        var halfWidth=width/2

        while ((halfHeight / inSampleSize) >= a && (halfWidth / inSampleSize) >= b){
            inSampleSize *=2
        }
    }

    return inSampleSize
}


    fun  decodeSampleBitmapResource( res : Resources,resId : Int,reqHeiht :Int, reqWidth:Int ): Bitmap  {
        val options=BitmapFactory.Options()
        options.inJustDecodeBounds=true
        BitmapFactory.decodeResource(   res, resId, options)
        options.inSampleSize=sampleSize(options,reqHeiht,reqWidth)

        options.inJustDecodeBounds=false

        return BitmapFactory.decodeResource(res,resId,options)
    }

}