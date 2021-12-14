package com.example.smidule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

val datalist_title = mutableListOf<String>()
val datalist_kikan = mutableListOf<String>()

class BaseTravelData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_travel_data)

        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference()

        //val bt1 : Button = findViewById(R.id.bt1)
        //val bt2 : Button = findViewById(R.id.bt2)
        val plus : Button = findViewById(R.id.plus)//計画追加するぼたん（追加する画面へ遷移）
        val memo1 : Button = findViewById(R.id.memo1)//計画を登録したら現れるボタン
        val memo2 : Button = findViewById(R.id.memo2)//うえにおなじく

        memo1.visibility = View.INVISIBLE
        memo2.visibility = View.INVISIBLE


        if(memo1_Flag == true){
            memo1Create("計画名をいれたいですぱーと１") // TravelAddで得たデータを獲得していれたい
        }
        if(memo2_Flag == true){
            memo2Create("計画名をいれたいですぱーと２")
        }

        //val pref = PreferenceManager.getDefaultSharedPreferences(this).apply()
        //al tit = pref.getString("titl","")
        //title.setText(titl)

        //HashMap<String,String> map = new HashMap<String,String>();

        //val sharedPref = getSharedPreferences("title",Context.MODE_PRIVATE)
        //val preferencesEditor: SharedPreferences.Editor=sharedPref.edit()
        //val str = sharedPref.getString("")

//ボタンを押したらデータベースにタイトルと期間を登録できる（今は2個までとしておく）
        plus.setOnClickListener {
            val intent = Intent(this, TravelAdd::class.java)
            startActivity(intent)
        }

        memo1.setOnClickListener{

        }
        memo2.setOnClickListener{

        }

    }

    private fun memo1Create(title:String) {
        val memo1: Button = findViewById(R.id.memo1)
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference(title)
        if (ref != null) {
            memo1.visibility = View.VISIBLE//ボタンを表示させてるよ
            memo1.text=title
        }
    }

    private fun memo2Create(title:String){
        val memo2 : Button = findViewById(R.id.memo2)
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference(title)
        if(ref != null){
            memo2.visibility = View.VISIBLE
            memo2.text=title
        }
    }
}

