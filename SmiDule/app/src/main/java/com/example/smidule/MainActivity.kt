package com.example.smidule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ScrollView
import android.widget.LinearLayout
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    //private var day_textview: TextView? = null
    //private var line_view: View? = null
    //private var yoteiadd_button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var day_textview: TextView = findViewById(R.id.day_textview)
    var line_view: View = findViewById(R.id.line_view)
    var yoteiadd_button: Button = findViewById(R.id.yoteiadd_button)

    /*yoteiadd_button.setOnClickListener{
        /Intent intent = new Intent(this, 遷移先画面のくラス名::class.java)
        startActivity(intent)
    }*/
}