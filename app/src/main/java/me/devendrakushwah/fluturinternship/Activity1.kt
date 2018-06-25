package me.devendrakushwah.fluturinternship

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.util.Log
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout

class Activity1 : AppCompatActivity(), View.OnTouchListener {
    var mImageView: ImageView?=null
    var mRoot: ViewGroup?=null
    private var mXDelta: Int = 0
    private var mYDelta: Int = 0
    var btn : Button ?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        val actionBar = supportActionBar
        actionBar!!.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        btn=findViewById<Button>(R.id.btn)
        mRoot = findViewById<RelativeLayout>(R.id.rLayout)
        mImageView = findViewById<ImageView>(R.id.content_main_image_view)

        mImageView?.setOnTouchListener(this)
        btn?.setOnClickListener(
                {
                    intent=getIntent()
                    finish()
                    startActivity(intent)
                }
        )
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean { //onTouch() invoked until the image is tapped

        val x = event.rawX.toInt()       //current x coordinate
        val y = event.rawY.toInt()         // current y coordinate
        Log.d("Position","X : "+x.toString()+", Y : "+y.toString()) // to write in log

        //switch cases :-
        when (event.action and MotionEvent.ACTION_MASK) {
            MotionEvent.ACTION_DOWN -> {
                val lParams = mImageView?.layoutParams as RelativeLayout.LayoutParams
                mXDelta = x - lParams.leftMargin
                mYDelta = y - lParams.topMargin
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_DOWN, MotionEvent.ACTION_POINTER_UP -> {
            }
            MotionEvent.ACTION_MOVE -> {
                val layoutParams = mImageView?.layoutParams as RelativeLayout.LayoutParams
                layoutParams.leftMargin = x - mXDelta
                layoutParams.topMargin = y - mYDelta
                layoutParams.rightMargin = -250
                layoutParams.bottomMargin = -250
                mImageView?.layoutParams = layoutParams
            }
        }
        mRoot?.invalidate()
        return true
    }
}