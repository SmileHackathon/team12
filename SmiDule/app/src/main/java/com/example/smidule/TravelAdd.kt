package com.example.smidule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.FirebaseDatabase

var Data_control1 = 1 //データ数制御　
var Data_control2 = 1 //
//var index = 0;
var memo1_Flag : Boolean = false //計画登録したら現れるボタンが出現するか
var memo2_Flag : Boolean = false//うえにおなじく

class TravelAdd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_add)
        val title : EditText = findViewById(R.id.title)
        val kikan : EditText = findViewById(R.id.kikan)
        val tuika : Button = findViewById(R.id.tuika)

        //var index = getSharedPreferences("index", Context.MODE_PRIVATE)
        //index.edit().putInt("index", 0).apply()
        //var Data_control1 = getSharedPreferences("dc", Context.MODE_PRIVATE)
        //Data_control1.edit().putInt("dc", 1).apply()

        //var memo1Flag = getSharedPreferences("flag1", Context.MODE_PRIVATE)
        //memo1Flag.edit().putBoolean("flag1", false).apply()
        //var memo2Flag = getSharedPreferences("flag2", Context.MODE_PRIVATE)
        //memo2Flag.edit().putBoolean("flag2", false).apply()

        //memo1_Flag = memo1Flag.getBoolean("flag1",false)
        //memo2_Flag = memo2Flag.getBoolean("flag2",false)


        tuika.setOnClickListener() {
            if (Data_control1 == 1) {
                addData(title.text.toString(), kikan.text.toString())
                memo1_Flag = true
                Data_control1 = 2

                val intent = Intent(this,BaseTravelData::class.java)
                startActivity(intent)

            } else if (Data_control1 == 2) {
                addData(title.text.toString(), kikan.text.toString())
                memo2_Flag = true
                Data_control1 = 3

                val intent = Intent(this,BaseTravelData::class.java)
                startActivity(intent)
            } else if (Data_control1 != 1 && Data_control1 != 2) {
                //2個以上のデータを登録しようとしたら警告
                AlertDialog.Builder(this) // FragmentではActivityを取得して生成
                    .setTitle("Error!")
                    .setMessage("2個までしか登録できません（今のところ）")
                    .setPositiveButton("OK", null)
                    .show()
            }
            val intent = Intent(this, BaseTravelData::class.java)
            startActivity(intent)
        }
    }
    private fun addData(title: String, kikan : String){//データを追加する関数（タイトルがキーになってて（？）その子供が期間）のつもり
        if(Data_control2 != 3 ) {
            val database = FirebaseDatabase.getInstance()
            val ref = database.getReference(title)
            ref.setValue(kikan)
            Data_control2++
        }
    }

    private fun delateData(title : String){
        val database = FirebaseDatabase.getInstance();
        database.getReference(title)
        database.getReference(title).setValue(null);
    }

    private fun add(title : String, s : Sche_Stracture){
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference(title)
        ref.setValue(s)
    }

    /* private fun inData(title : String, kikan : String){
         datalist_title.add(index, title)
         datalist_kikan.add(index, kikan)
         index++
     }*/

}