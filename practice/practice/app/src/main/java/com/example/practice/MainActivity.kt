package com.example.practice

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.json.JSONArray


var i = 0
var j = 0
var name1 : String = ""

//val nakami = db.collection("Travel").orderBy("title", Query.Direction.ASCENDING)
//val options = FirestoreRecyclerOptions.Builder<Travel>().setQuery(nakami, Travel::class.java).build()
class MainActivity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var title: EditText = findViewById(R.id.title)
        var tuika1: Button = findViewById(R.id.tuika1)
        var bt1: Button = findViewById(R.id.bt1)
        var bt2: Button = findViewById(R.id.bt2)
        var bt3: Button = findViewById(R.id.bt3)
        var bt4: Button = findViewById(R.id.bt4)
        var bt5: Button = findViewById(R.id.bt5)
        var bt6: Button = findViewById(R.id.bt6)
        val frag1 = getSharedPreferences("btn1", Context.MODE_PRIVATE)
        val fragstore1 = frag1.getBoolean("btn1",false)
        val frag2 = getSharedPreferences("btn2", Context.MODE_PRIVATE)
        val fragstore2 = frag2.getBoolean("btn2",false)
        val frag3 = getSharedPreferences("btn3", Context.MODE_PRIVATE)
        val fragstore3 = frag3.getBoolean("btn3",false)
        val frag4 = getSharedPreferences("btn4", Context.MODE_PRIVATE)
        val fragstore4 = frag4.getBoolean("btn4",false)
        val frag5 = getSharedPreferences("btn5", Context.MODE_PRIVATE)
        val fragstore5 = frag5.getBoolean("btn5",false)
        val frag6 = getSharedPreferences("btn6", Context.MODE_PRIVATE)
        val fragstore6 = frag6.getBoolean("btn6",false)
        val data1 = getSharedPreferences("data1", Context.MODE_PRIVATE)
        val data1store = data1.getString("data1","false")
        val data2 = getSharedPreferences("data2", Context.MODE_PRIVATE)
        val data2store = data2.getString("data2","false")
        val data3 = getSharedPreferences("data3", Context.MODE_PRIVATE)
        val data3store = data3.getString("data3","false")
        val data4 = getSharedPreferences("data4", Context.MODE_PRIVATE)
        val data4store = data4.getString("data4","false")
        val data5 = getSharedPreferences("data5", Context.MODE_PRIVATE)
        val data5store = data5.getString("data5","false")
        val data6 = getSharedPreferences("data6", Context.MODE_PRIVATE)
        val data6store = data6.getString("data6","false")
        //val travelList : ArrayList<Travel> = ArrayList()
        
        tuika1.setOnClickListener {
            val travel = Travel("empty", "empty")
            //travelList.add(travel)
            i++

            if (i == 1) {
                data1.edit().putString("data1",title.text.toString()).commit()
                data1.getString("data1","false")
                addData(db, data1.getString("data1","false").toString(),"empty",travel)
                //name1 = data1.getString("data1","false").toString()
                frag1.edit().putBoolean("btn1",true).commit()
                frag1.getBoolean("btn1",false)
                bt1.text = data1.getString("data1","false").toString()
                bt1.visibility = View.VISIBLE
            }
            if (i == 2) {
                data2.edit().putString("data2",title.text.toString()).commit()
                data2.getString("data2","false")
                addData(db, data2.getString("data2","false").toString(),"empty",travel)
                //name1 = data1.getString("data2","false").toString()
                frag2.edit().putBoolean("btn2",true).commit()
                frag2.getBoolean("btn2",false)
                bt2.text = data2.getString("data2","false").toString()
                bt2.visibility = View.VISIBLE
            }
            if (i == 3) {
                data3.edit().putString("data3",title.text.toString()).commit()
                data3.getString("data3","false")
                addData(db, data3.getString("data3","false").toString(),"empty",travel)
                //name1 = data1.getString("data2","false").toString()
                frag3.edit().putBoolean("btn3",true).commit()
                frag3.getBoolean("btn3",false)
                bt3.text = data3.getString("data3","false").toString()
                bt3.visibility = View.VISIBLE
            }
            if (i == 4) {
                data4.edit().putString("data4",title.text.toString()).commit()
                data4.getString("data4","false")
                addData(db, data4.getString("data4","false").toString(),"empty",travel)
                //name1 = data1.getString("data4","false").toString()
                frag4.edit().putBoolean("btn4",true).commit()
                frag4.getBoolean("btn4",false)
                bt4.text = data4.getString("data4","false").toString()
                bt4.visibility = View.VISIBLE
            }
            if (i == 5) {
                data5.edit().putString("data5",title.text.toString()).commit()
                data5.getString("data5","false")
                addData(db, data5.getString("data5","false").toString(),"empty",travel)
                //name1 = data1.getString("data4","false").toString()
                frag5.edit().putBoolean("btn5",true).commit()
                frag5.getBoolean("btn5",false)
                bt5.text = data5.getString("data5","false").toString()
                bt5.visibility = View.VISIBLE
            }
            if (i == 6) {
                i=100
                data6.edit().putString("data6",title.text.toString()).commit()
                data6.getString("data6","false")
                addData(db, data6.getString("data6","false").toString(),"empty",travel)
                //name1 = data1.getString("data6","false").toString()
                frag6.edit().putBoolean("btn6",true).commit()
                frag6.getBoolean("btn6",false)
                bt6.text = data6.getString("data6","false").toString()
                bt6.visibility = View.VISIBLE

            }
            if(i==100){
                AlertDialog.Builder(this) // FragmentではActivityを取得して生成
                    .setTitle("Error")
                    .setMessage("満杯になりました")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }

        bt1.setOnClickListener {
            val intent = Intent(this@MainActivity, gamen2::class.java).apply {
                val ( key,value) = getData(db,data1.getString("data1", "false").toString())

                putExtra("key1", data1.getString("data1", "false").toString())//東京旅行をわたす
                putStringArrayListExtra("key2", key)
                putStringArrayListExtra("key3",value)
            }
                startActivity(intent)
        }
        bt2.setOnClickListener {
            val intent = Intent(this@MainActivity, gamen2::class.java).apply {
                val ( key,value) = getData(db,data2.getString("data2", "false").toString())

                putExtra("key1", data2.getString("data2", "false").toString())//東京旅行をわたす
                putStringArrayListExtra("key2", key)
                putStringArrayListExtra("key3",value)
            }
            startActivity(intent)
        }
        bt3.setOnClickListener {
            val intent = Intent(this@MainActivity, gamen2::class.java).apply {
                val ( key,value) = getData(db,data3.getString("data3", "false").toString())

                putExtra("key1", data1.getString("data3", "false").toString())//東京旅行をわたす
                putStringArrayListExtra("key2", key)
                putStringArrayListExtra("key3",value)
            }
            startActivity(intent)
        }
        bt4.setOnClickListener {
            val intent = Intent(this@MainActivity, gamen2::class.java).apply {
                val ( key,value) = getData(db,data4.getString("data4", "false").toString())

                putExtra("key1", data1.getString("data4", "false").toString())//東京旅行をわたす
                putStringArrayListExtra("key2", key)
                putStringArrayListExtra("key3",value)
            }
            startActivity(intent)
        }
        bt5.setOnClickListener {
            val intent = Intent(this@MainActivity, gamen2::class.java).apply {
                val ( key,value) = getData(db,data5.getString("data5", "false").toString())

                putExtra("key1", data1.getString("data5", "false").toString())//東京旅行をわたす
                putStringArrayListExtra("key2", key)
                putStringArrayListExtra("key3",value)
            }
            startActivity(intent)
        }
        bt6.setOnClickListener {
            val intent = Intent(this@MainActivity, gamen2::class.java).apply {
                val ( key,value) = getData(db,data6.getString("data1", "false").toString())

                putExtra("key1", data6.getString("data6", "false").toString())//東京旅行をわたす
                putStringArrayListExtra("key2", key)
                putStringArrayListExtra("key3",value)
            }
            startActivity(intent)
        }
        if(frag1.getBoolean("btn1",false) == false){
            bt1.visibility = View.INVISIBLE
        }
        if(frag2.getBoolean("btn2",false) == false){
            bt2.visibility = View.INVISIBLE
        }
        if(frag3.getBoolean("btn3",false) == false){
            bt3.visibility = View.INVISIBLE
        }
        if(frag4.getBoolean("btn4",false) == false){
            bt4.visibility = View.INVISIBLE
        }
        if(frag5.getBoolean("btn5",false) == false){
            bt5.visibility = View.INVISIBLE
        }
        if(frag6.getBoolean("btn6",false) == false){
            bt6.visibility = View.INVISIBLE
        }
        /*if(frag1.getBoolean("btn1",false) == true){
            bt1.text = data1.getString("data1","false").toString()
        }
        if(frag2.getBoolean("btn2",false) == true){
            bt2.text = data2.getString("data2","false").toString()
        }*/
    }
    /*fun save(key : String , arrayList : ArrayList<Travel>){
        val shardPreferences = this.getPreferences(Context.MODE_PRIVATE)
        val shardPrefEditor = shardPreferences.edit()
        val jsonArray = JSONArray(arrayList)//保存したいリストを JSONArray にパース
        shardPrefEditor.putString(key, jsonArray.toString())
        shardPrefEditor.apply()
    }*/
}
fun addData(db: FirebaseFirestore,  tokyoryokou: String, hikouki : String,travel: Travel) {
    db.collection(tokyoryokou)
        .document(hikouki)
        .set(travel)
        .addOnSuccessListener { documentReference ->
            Log.d(ContentValues.TAG, "addData/plan")
        }
        .addOnFailureListener { e -> Log.d(ContentValues.TAG, "Error adding document" + e) }
}












/*if(i==0) {
    bt1.visibility = View.INVISIBLE
    bt2.visibility = View.INVISIBLE
}
    tuika1.setOnClickListener{
        val travel = Travel("null","null","null")
        i++

        if (i == 1) {
            addData(db, travel, "Travel", title.text.toString())
            bt1.text = db.collection("Travel").get().toString()
            name = title.text.toString()
            bt1.visibility = View.VISIBLE
        } else if (i == 2) {
            bt2.text = db.collection("Travel").get().toString()
            //
        } else {
            AlertDialog.Builder(this) // FragmentではActivityを取得して生成
                .setTitle("Error")
                .setMessage("2")
                .setPositiveButton("OK", null)
                .show()
        }

        bt1.setOnClickListener {
            val intent = Intent(this, gamen2::class.java)
            startActivity(intent)
        }

    }


}
        fun addData(db: FirebaseFirestore, travel: Travel, collection: String, document: String) {
            db.collection(collection)
                .document(document)
                .set(travel)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "addData/travel")
                }
                .addOnFailureListener { e -> Log.d(TAG, "Error adding document" + e) }
        }
*/






