package com.example.practice

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.firebase.firestore.FirebaseFirestore


var n =""

//val travelList : MutableMap<String,Travel> = mutableMapOf()

class gamen2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gamen2)

        val tuika2: Button = findViewById(R.id.tuika2) //予定追加ボタン
        val planList: ListView = findViewById(R.id.travelList) // 予定一覧

        val text1 = intent.getStringExtra("key1")
        val text2 = intent.getStringArrayListExtra("key2")//arrayList
        val text3 = intent.getStringArrayListExtra("key3")//arrayList

        val text_list =text3!!.toList()
        val text_mu = text3!!.toMutableList()

        Log.d("aaaaaaaaaafdg", text2.toString())
        Log.d("bbbbbbbbbbbb", text3.toString())


        val adapter = ArrayAdapter<String>(//リストにトラベルのデータを格納
            this,
            android.R.layout.simple_expandable_list_item_1,
            arrayListOf()//最初は空
        )
        val db = FirebaseFirestore.getInstance()

        planList.adapter = adapter
        adapter.addAll(text3)

        planList.setOnItemClickListener { parent, view, position, id ->//リストをタップすると予定の詳細を表示suruyounisitai
            val intent = Intent(this, gamen3::class.java)
            startActivity(intent)
        }

        //readFireStore(name1,n)
        tuika2.setOnClickListener {
            val plan = EditText(this)//planを登録するところ（アラートダイアログにて登録し、Travelのなかのplanのみ登録、他はNULLとする
                AlertDialog.Builder(this) // FragmentではActivityを取得して生成
                    .setTitle("add")
                    .setMessage("add")
                    .setView(plan)
                    .setPositiveButton(
                        "add",
                        DialogInterface.OnClickListener { dialogInterface, p ->
                            val pl: String = plan.text.toString()
                            val tr: Travel = Travel("empty", "empty")
                            addData(db, text1!!, pl, tr)
                            text3.add(pl)
                            adapter.add(pl)//
                        })
                    .setNegativeButton("cancel", null)
                    .show()

                Log.d("rrrrrrrrrrrrrrrr", text3.toString())
            }



/*fun readFireStore(tokyoryokou : String,hikouki : String){
        val travels = ArrayList<Travel>()
        val db = FirebaseFirestore.getInstance()
        db.collection(tokyoryokou).document(hikouki).get()
            .addOnCompleteListener{
                if(it.isSuccessful){
                    travels.add(Travel("starttime","endtime"))
                    /*for (doc in it.result) {
                        var result = Result(doc.data.getValue("username").toString(), "${doc.data.getValue("score")} / 10")
                        travels.add(result)
                    }*/
                }else{

                }

            }*/

    }

    }

fun getData(
    db: FirebaseFirestore,
    collection: String
): Pair<ArrayList<String>, ArrayList<String>> {
    var travel: Travel = Travel("null", "null")
    val map: MutableMap<String, String> = mutableMapOf()
    val key: ArrayList<String> = arrayListOf()
    val value: ArrayList<String> = arrayListOf()
    db.collection(collection)
        .get()
        .addOnCompleteListener { documents ->
            val document = documents.result
            Log.d(TAG, document?.documents.toString())
            if (documents.isSuccessful) {
                val document = documents.result
                Log.d(TAG, "aaaaaaaaaaaaa")
                if (document != null) {
                    Log.d(TAG, document.documents.toString())
                    Log.d(TAG, "getData")
                    for (i in document.documents.toString()) {
                        key.add(i.toString())
                        value.add(document.documents.toString())
                        //map.put(i.toString(),document.documents.toString())
                    }
                    //val list = arrayOf<MutableList<String>,MutableList<String>>(key,value)
                    //document.documents
                    //Log.d(TAG, "DocumentSnapshot data: " + document.data?.get("startTime"))
                    //Log.d(TAG, "DocumentSnapshot data: " + document.data?.get("endTime"))
                    //travel = Travel(document.data?.get("startTime").toString(),document.data?.get("endTime").toString())
                } else {
                    Log.d(TAG, "No such document")
                    //travel = Travel("null","null")
                }
            } else {
                Log.d(TAG, "get failed with " + documents.exception)
                //travel = Travel("null","null")
            }
        }
        .addOnFailureListener { e -> Log.d(TAG, "Error adding document" + e) }

    Log.d(TAG, Pair(key, value).toString())
    return Pair(key, value)
}





