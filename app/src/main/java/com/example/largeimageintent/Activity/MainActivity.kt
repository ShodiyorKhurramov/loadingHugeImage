package com.example.largeimageintent.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.largeimageintent.R

class MainActivity : AppCompatActivity() {
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Main Activity"



        val button=findViewById<Button>(R.id.bt_start)

        button.setOnClickListener{
            initView()
        }
    }


    private fun initView() {
        startButton()
    }


    private fun startButton() {
      val  intent= Intent(this, SecondaryActivity :: class.java)
        startActivity(intent)
    }

}


