package com.example.practice

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class gamen3 : AppCompatActivity() {
    var db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gamen3)

        var start_t : EditText = findViewById(R.id.start_t)
        var end_t : EditText = findViewById(R.id.end_t)
        var tuikaplan : Button = findViewById(R.id.tuikaplan)
        var planname : TextView = findViewById(R.id.planname)

        planname.text = n

        tuikaplan.setOnClickListener{
            val travel = Travel( start_t.text.toString(),end_t.text.toString())
            //travelList.put(n,travel)
            addData(db,name1,n,travel)
            val intent = Intent(this, gamen2::class.java)
            startActivity(intent)
        }

    }

}