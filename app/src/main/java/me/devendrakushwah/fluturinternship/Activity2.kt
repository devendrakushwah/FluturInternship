package me.devendrakushwah.fluturinternship

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import jp.wasabeef.blurry.Blurry

class Activity2 : AppCompatActivity() {
    var btn1 : Button ?=null                // blur button
    var btn2 : Button ?=null                // unblur button
    var rLayout : RelativeLayout ?= null       // relative layout containing images to be blurred

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        btn1=findViewById<Button>(R.id.btn1)
        btn2=findViewById<Button>(R.id.btn2)
        rLayout=findViewById<RelativeLayout>(R.id.rLayout)

        var blurred : Boolean = false  //variable to store current blur state
        btn1?.setOnClickListener({
            if(!blurred){                       //to check if image is currently not blurred and blur the image
            Blurry.with(this@Activity2)
                    .radius(25)
                    .sampling(2)
                    .async()
                    .animate(500)
                    .onto(rLayout as ViewGroup)
            blurred=true                                  // blur the image and set current state to true
        } })
        btn2?.setOnClickListener({              // to unblur the image
            Blurry.delete(rLayout as ViewGroup)
            blurred=false                         //set current state to unblur
        })
        }
    }