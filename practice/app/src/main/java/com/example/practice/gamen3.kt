package com.example.practice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class gamen3 : AppCompatActivity() {
    companion object {
        val KEY_STATE = "key_state"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gamen3)

        val start_t : EditText = findViewById(R.id.start_t)
        //var startbutton : Button = findViewById(R.id.start)
        val end_t : EditText = findViewById(R.id.end_t)
        val tuikaplan : Button = findViewById(R.id.add_button)
        val keikaku : TextView = findViewById(R.id.keikaku)
        val place : EditText = findViewById(R.id.place_text)
        val st : TextView = findViewById(R.id.st)
        val end : TextView = findViewById(R.id.end)
        val photoadd : Button = findViewById(R.id.photoadd)

        val db = FirebaseFirestore.getInstance()

        val time_s = getSharedPreferences("start", Context.MODE_PRIVATE)
        val time_e = getSharedPreferences("start", Context.MODE_PRIVATE)

        val state = intent.getSerializableExtra(KEY_STATE)
        val text1 = intent.getStringExtra("keikaku")
        val plan = intent.getStringExtra("plan")
        val text3 = intent.getStringArrayListExtra("text3")
        //val tra = intent.get
        var text_list =text3!!.toList()//
        val text_mu = text3!!.toMutableList()//text3はarrayListだけどそれをmutableListにかえた
        var start :String = ""
        var goal :String = ""
        if(state is Travel){
            start = state.startTime
            println(state.startTime)
            goal = state.endTime
            println(state.endTime)
        }
        keikaku.text = text1

//        startbutton.setOnClickListener{//コレクションからｄｏｃｕｍｅｎｔをさくじょしたい
//            //db.collection(text1!!).document(plan!!).delete()
//            //text_mu.removeAt(text3pl)
//            //text_list = text_mu.toList()
//            //text3 = text_list.toTypedArray()
//            val intent = Intent(this,gamen2::class.java)
//            startActivity(intent)
//        }
//        planname.text =start
//
//        //Log.d("travellllll", travel.toString())
//        Log.d("plannnnnnn", plan.toString())
//        Log.d("text111111", text1.toString())
//

        tuikaplan.setOnClickListener{
            val travel = Travel( start_t.text.toString(),end_t.text.toString(),place.text.toString())
           addData(db,text1!!,plan.toString(),travel)
            //db.collection.document(plan)
            time_s.edit().putString("start", getTravel(db,text1,plan!!).startTime.toString()).commit()
            st.text = time_s.getString("start", "false")
            time_e.edit().putString("end", end_t.text.toString()).commit()
            end.text = time_e.getString("end", "false")
            //db.collection(text1!!).document(plan!!).set(travel)
            Log.d("travellllll", travel.toString())
          Log.d("plannnnnnn", plan.toString())
           Log.d("text111111", text1.toString())         //intent.putExtra("Travel",travel)         //intent.putExtra("text3a",text3)
        finish()
        }
        photoadd.setOnClickListener{
                val intent = Intent(this,gazou::class.java)
                startActivity(intent)
        }
   }
}