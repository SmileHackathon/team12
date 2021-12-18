package com.example.practice

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore


//val nakami = db.collection("Travel").orderBy("title", Query.Direction.ASCENDING)
//val options = FirestoreRecyclerOptions.Builder<Travel>().setQuery(nakami, Travel::class.java).build()
class MainActivity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()
    val result: MutableLiveData<Pair<ArrayList<String>, ArrayList<String>>> = MutableLiveData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data1 = getSharedPreferences("data1", Context.MODE_PRIVATE)

        var title: EditText = findViewById(R.id.title)
        var tuika1: Button = findViewById(R.id.tuika1)
        var bt1: Button = findViewById(R.id.bt1)
        var bt2: Button = findViewById(R.id.bt2)
        var bt3: Button = findViewById(R.id.bt3)
        var bt4: Button = findViewById(R.id.bt4)
        var bt5: Button = findViewById(R.id.bt5)
        var bt6: Button = findViewById(R.id.bt6)

        val i = getSharedPreferences("i", Context.MODE_PRIVATE)
        val istore = i.getInt("i",Context.MODE_PRIVATE)
        val j = getSharedPreferences("j", Context.MODE_PRIVATE)
        val jstore = j.getInt("j",Context.MODE_PRIVATE)
        val frag1 = getSharedPreferences("btn1", Context.MODE_PRIVATE)
        val fragstore1 = frag1.getBoolean("btn1", false)
        val frag2 = getSharedPreferences("btn2", Context.MODE_PRIVATE)
        val fragstore2 = frag2.getBoolean("btn2", false)
        val frag3 = getSharedPreferences("btn3", Context.MODE_PRIVATE)
        val fragstore3 = frag3.getBoolean("btn3", false)
        val frag4 = getSharedPreferences("btn4", Context.MODE_PRIVATE)
        val fragstore4 = frag4.getBoolean("btn4", false)
        val frag5 = getSharedPreferences("btn5", Context.MODE_PRIVATE)
        val fragstore5 = frag5.getBoolean("btn5", false)
        val frag6 = getSharedPreferences("btn6", Context.MODE_PRIVATE)
        val fragstore6 = frag6.getBoolean("btn6", false)
        // val data1 = getSharedPreferences("data1", Context.MODE_PRIVATE)
        val data1store = data1.getString("data1", "false")
        val data2 = getSharedPreferences("data2", Context.MODE_PRIVATE)
        val data2store = data2.getString("data2", "false")
        val data3 = getSharedPreferences("data3", Context.MODE_PRIVATE)
        val data3store = data3.getString("data3", "false")
        val data4 = getSharedPreferences("data4", Context.MODE_PRIVATE)
        val data4store = data4.getString("data4", "false")
        val data5 = getSharedPreferences("data5", Context.MODE_PRIVATE)
        val data5store = data5.getString("data5", "false")
        val data6 = getSharedPreferences("data6", Context.MODE_PRIVATE)
        val data6store = data6.getString("data6", "false")


        tuika1.setOnClickListener {
            var travel = Travel("empty", "empty","empty")
            var plan = "empty"
            i.edit().putInt("i",i.getInt("i",0)+1).commit()
            if (i.getInt("i",0)==1) {
                data1.edit().putString("data1", title.text.toString()).commit()
                data1.getString("data1", "false")
                addData(db, data1.getString("data1", "false").toString(), plan, travel)
                frag1.edit().putBoolean("btn1", true).commit()
                frag1.getBoolean("btn1", false)
                bt1.text = data1.getString("data1", "false").toString()
                bt1.visibility = View.VISIBLE
                title.post { title.getText().clear() }
            }
            if (i.getInt("i",0)== 2) {
                data2.edit().putString("data2", title.text.toString()).commit()
                data2.getString("data2", "false")
                addData(db, data2.getString("data2", "false").toString(), "empty", travel)
                //name1 = data1.getString("data2","false").toString()
                frag2.edit().putBoolean("btn2", true).commit()
                frag2.getBoolean("btn2", false)
                bt2.text = data2.getString("data2", "false").toString()
                bt2.visibility = View.VISIBLE
                title.post { title.getText().clear() }
            }
            if (i.getInt("i",0) == 3) {
                data3.edit().putString("data3", title.text.toString()).commit()
                data3.getString("data3", "false")
                addData(db, data3.getString("data3", "false").toString(), "empty", travel)
                frag3.edit().putBoolean("btn3", true).commit()
                frag3.getBoolean("btn3", false)
                bt3.text = data3.getString("data3", "false").toString()
                bt3.visibility = View.VISIBLE
                title.post { title.getText().clear() }
            }
            if (i.getInt("i",0) == 4) {
                data4.edit().putString("data4", title.text.toString()).commit()
                data4.getString("data4", "false")
                addData(db, data4.getString("data4", "false").toString(), "empty", travel)
                frag4.edit().putBoolean("btn4", true).commit()
                frag4.getBoolean("btn4", false)
                bt4.text = data4.getString("data4", "false").toString()
                bt4.visibility = View.VISIBLE
                title.post { title.getText().clear() }
            }
            if (i.getInt("i",0) == 5) {
                data5.edit().putString("data5", title.text.toString()).commit()
                data5.getString("data5", "false")
                addData(db, data5.getString("data5", "false").toString(), "empty", travel)
                frag5.edit().putBoolean("btn5", true).commit()
                frag5.getBoolean("btn5", false)
                bt5.text = data5.getString("data5", "false").toString()
                bt5.visibility = View.VISIBLE
                title.post { title.getText().clear() }
            }
            if (i.getInt("i",0)== 6) {
                data6.edit().putString("data6", title.text.toString()).commit()
                data6.getString("data6", "false")
                addData(db, data6.getString("data6", "false").toString(), "empty", travel)
                frag6.edit().putBoolean("btn6", true).commit()
                frag6.getBoolean("btn6", false)
                bt6.text = data6.getString("data6", "false").toString()
                bt6.visibility = View.VISIBLE
                i.edit().putInt("i",100).commit()
                title.post { title.getText().clear() }
            }
            if (i.getInt("i",0) > 100) {
                AlertDialog.Builder(this) // FragmentではActivityを取得して生成
                    .setTitle("Error")
                    .setMessage("満杯になりました")
                    .setPositiveButton("OK", null)
                    .show()
            }
            if(title.text.equals("")){//文字が入力されなかったら
                AlertDialog.Builder(this) // FragmentではActivityを取得して生成
                    .setTitle("Error")
                    .setMessage("入力されていません。")
                    .setPositiveButton("OK", null)
                    .show()
            }

        }
        bt1.setOnClickListener {
            j.edit().putInt("j",1).commit()
                val (key, value) = getData(db, data1.getString("data1", "false").toString())
        }
        bt2.setOnClickListener {
            j.edit().putInt("j",2).commit()
            val (key, value) = getData(db, data2.getString("data2", "false").toString())

        }
        bt3.setOnClickListener {
            j.edit().putInt("j",3).commit()
                val (key, value) = getData(db, data3.getString("data3", "false").toString())

        }
        bt4.setOnClickListener {
            j.edit().putInt("j",4).commit()
                val (key, value) = getData(db, data4.getString("data4", "false").toString())

        }
        bt5.setOnClickListener {
            j.edit().putInt("j",5).commit()
                val (key, value) = getData(db, data5.getString("data5", "false").toString())

        }
        bt6.setOnClickListener {
            j.edit().putInt("j",6).commit()
                val (key, value) = getData(db, data6.getString("data1", "false").toString())

        }
        if (frag1.getBoolean("btn1", false) == false) {
            bt1.visibility = View.INVISIBLE
        }
        if (frag2.getBoolean("btn2", false) == false) {
            bt2.visibility = View.INVISIBLE
        }
        if (frag3.getBoolean("btn3", false) == false) {
            bt3.visibility = View.INVISIBLE
        }
        if (frag4.getBoolean("btn4", false) == false) {
            bt4.visibility = View.INVISIBLE
        }
        if (frag5.getBoolean("btn5", false) == false) {
            bt5.visibility = View.INVISIBLE
        }
        if (frag6.getBoolean("btn6", false) == false) {
            bt6.visibility = View.INVISIBLE
        }
        if (frag1.getBoolean("btn1", false) == true) {
            bt1.text = data1.getString("data1", "false").toString()
        }
        if (frag2.getBoolean("btn2", false) == true) {
            bt2.text = data2.getString("data2", "false").toString()
        }
        if (frag3.getBoolean("btn3", false) == true) {
            bt3.text = data3.getString("data3", "false").toString()
        }
        if (frag4.getBoolean("btn4", false) == true) {
            bt4.text = data4.getString("data4", "false").toString()
        }
        if (frag5.getBoolean("btn5", false) == true) {
            bt5.text = data5.getString("data5", "false").toString()
        }
        if (frag6.getBoolean("btn6", false) == true) {
            bt6.text = data6.getString("data6", "false").toString()
        }
        result.observe(this, {
            //resultが書き変わった時に実行される
            if (j.getInt("j",1) == 1 ) {
                val intent = Intent(this@MainActivity, gamen2::class.java).apply {
                    Log.d("ccccccccccc", data1.getString("data1", "false").toString())
                    putExtra("key1", data1.getString("data1", "false").toString())//計画名を渡す
                    putStringArrayListExtra("key2", it.first)
                    putStringArrayListExtra("key3", it.second)//data1に入っているドキュメント名のリスト
                    //Log.d("fffffffffffffff",value.toString())
                }
                startActivity(intent)
                Log.d("result", it.toString())
            }
            if (j.getInt("j",1) == 2 ) {
                val intent = Intent(this@MainActivity, gamen2::class.java).apply {
                    Log.d("ccccccccccc", data2.getString("data2", "false").toString())
                    putExtra("key1", data2.getString("data2", "false").toString())//計画名を渡す
                    putStringArrayListExtra("key2", it.first)
                    putStringArrayListExtra("key3", it.second)//data1に入っているドキュメント名のリスト
                    //Log.d("fffffffffffffff",value.toString())
                }
                startActivity(intent)
                Log.d("result", it.toString())
            }
            if (j.getInt("j",1)== 3 ) {
                val intent = Intent(this@MainActivity, gamen2::class.java).apply {
                    Log.d("ccccccccccc", data3.getString("data3", "false").toString())
                    putExtra("key1", data3.getString("data3", "false").toString())//計画名を渡す
                    putStringArrayListExtra("key2", it.first)
                    putStringArrayListExtra("key3", it.second)//data1に入っているドキュメント名のリスト
                    //Log.d("fffffffffffffff",value.toString())
                }
                startActivity(intent)
                Log.d("result", it.toString())
            }
            if (j.getInt("j",1) == 4 ) {
                val intent = Intent(this@MainActivity, gamen2::class.java).apply {
                    Log.d("ccccccccccc", data4.getString("data4", "false").toString())
                    putExtra("key1", data4.getString("data4", "false").toString())//計画名を渡す
                    putStringArrayListExtra("key2", it.first)
                    putStringArrayListExtra("key3", it.second)//data1に入っているドキュメント名のリスト
                    //Log.d("fffffffffffffff",value.toString())
                }
                startActivity(intent)
                Log.d("result", it.toString())
            }
            if (j.getInt("j",1)== 5 ) {
                val intent = Intent(this@MainActivity, gamen2::class.java).apply {
                    Log.d("ccccccccccc", data5.getString("data5", "false").toString())
                    putExtra("key1", data5.getString("data5", "false").toString())//計画名を渡す
                    putStringArrayListExtra("key2", it.first)
                    putStringArrayListExtra("key3", it.second)//data1に入っているドキュメント名のリスト
                    //Log.d("fffffffffffffff",value.toString())
                }
                startActivity(intent)
                Log.d("result", it.toString())
            }
            if (j.getInt("j",1)== 6 ) {
                val intent = Intent(this@MainActivity, gamen2::class.java).apply {
                    Log.d("ccccccccccc", data6.getString("data6", "false").toString())
                    putExtra("key1", data6.getString("data6", "false").toString())//計画名を渡す
                    putStringArrayListExtra("key2", it.first)
                    putStringArrayListExtra("key3", it.second)//data1に入っているドキュメント名のリスト
                    //Log.d("fffffffffffffff",value.toString())
                }
                startActivity(intent)
                Log.d("result", it.toString())
            }
        })
    }


    fun getData(
        db: FirebaseFirestore,
        collection: String
    ): Pair<ArrayList<String>, ArrayList<String>> {
        //var travel: Travel = Travel("null", "null")
        //val map: MutableMap<String, String> = mutableMapOf()
        val key: ArrayList<String> = arrayListOf()
        val value: ArrayList<String> = arrayListOf()
        var count = 0
        db.collection(collection)
            .get()
            .addOnCompleteListener { documents ->
                if (documents.isSuccessful) {
                    val documents = documents.result?.documents
                    //Log.d(TAG, "getData")
                    if (documents != null) {
                        for (i in documents) {
                            key.add(count.toString())
                            value.add(i.id)
                            count++
                        }
                    } else {
                        Log.d(TAG, "No such document")
                    }
                    Log.d("valueaaaaaaaaaajjj", value.toString())//ここでは読み取れている
                    result.value = Pair(key, value)
                    Log.d("resulttt", Pair(key, value).toString())
                } else {
                    Log.d(TAG, "get failed with " + documents.exception)
                    //travel = Travel("null","null")
                }
            }
            .addOnFailureListener { e -> Log.d(TAG, "Error adding document" + e) }
        return Pair(key, value)
    }

}

fun addData(db: FirebaseFirestore, tokyoryokou: String, hikouki: String, travel: Travel) {
    db.collection(tokyoryokou)
        .document(hikouki)
        .set(travel)
        .addOnSuccessListener { documentReference ->
            Log.d(ContentValues.TAG, "addData/plan")
        }
        .addOnFailureListener { e -> Log.d(ContentValues.TAG, "Error adding document" + e) }
}









