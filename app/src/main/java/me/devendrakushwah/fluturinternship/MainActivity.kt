package me.devendrakushwah.fluturinternship

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var b1 : Button ?= null  //button1
    var b2 : Button ?= null  // button2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b1=findViewById(R.id.b1)
        b2=findViewById(R.id.b2)

        b1?.setOnClickListener(
            {
                var i1 : Intent=Intent(this@MainActivity,Activity1::class.java)
                startActivity(i1) // intent to activity1
            }
        )

        b2?.setOnClickListener(
            {
                var i2 : Intent=Intent(this@MainActivity,Activity2::class.java)
                startActivity(i2)  //intent to activity2
            }
        )
    }
}
