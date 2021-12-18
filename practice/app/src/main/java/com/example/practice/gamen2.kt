package com.example.practice

import android.app.Dialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.google.firebase.firestore.FirebaseFirestore


//val map : MutableMap<Int, String> =mutableMapOf<Int,String>()//時間、ドキュメント名)
class gamen2 : AppCompatActivity() , AlertDialogFragment.SampleDialogListener{
    val db = FirebaseFirestore.getInstance()
    var text1 = ""//コレクション名
    var text_mu : MutableList<String> = mutableListOf()
    lateinit var adapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gamen2)

  text1 = intent.getStringExtra("key1")?:""//コレクション名
        val tuika2: Button = findViewById(R.id.tuika2) //予定追加ボタン
        val modoru : Button = findViewById(R.id.modoru)
        val planList: ListView = findViewById(R.id.travelList) // 予定一覧
        val keikakuname : TextView = findViewById(R.id.keikaku)


        val text2 = intent.getStringArrayListExtra("key2")//documentのリストのキーがはいっている
        var text3 = intent.getStringArrayListExtra("key3")//text１の中に入っているdocumentの名前のリストがはいっている
        //val tra = intent.getSerializableExtra("tra")//画面３で登録したデータクラスの値を画面3から2へもってくる
        keikakuname.text = text1
        //text3 = intent.getStringArrayListExtra("text3a")

        val text_list =text3!!.toList()//
        val text_mu = text3!!.toMutableList()//text3はarrayListだけどそれをmutableListにかえた
        var pl : String = "pl"//ここで入力するプランの名前

        Log.d("aaaaaaaaaafdg", text2.toString())
        Log.d("bbbbbbbbbbbb", text3.toString())


        adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_expandable_list_item_1,
            arrayListOf()//最初は空
        )

        planList.adapter = adapter
        Log.d("ggggggg",text_mu.toString())

        adapter.addAll(text_mu)
Log.d("tagtag",text_mu.toString())

        planList.setOnItemClickListener { parent, view, position, id ->//リストをタップすると予定の詳細を表示suruyounisitai
            val intent = Intent(this, gamen3::class.java)
            //val travel : Travel
//            for(i in text_mu) {
//                intent.putExtra(text2.toString(), i)
//            }
            intent.putExtra("keikaku", text1)//コレクション名
            val textView = view.findViewById<TextView>(android.R.id.text1)
            intent.putExtra("plan",textView.text.toString())//)ｄｏｃｕｍｅｎｔ名
            Log.d("idddddddddddd",textView.text.toString())
            intent.putExtra("text3",text3)
            //intent.putExtra("travel",getTravel(db,text1!!,textView.text.toString()))//travel内のデータを次の画面へ渡す。
//            intent.putExtra("text3pl",text3.indexOf(pl))
            startActivity(intent)
        }
        //db.collection(text1!!).document("empty").delete()
        val view: View = layoutInflater.inflate(R.layout.editdaialog, null)
        //readFireStore(name1,n)
        //val edit = AppCompatEditText(this)
        tuika2.setOnClickListener {//planを登録するところ（アラートダイアログにて登録し、Travelのなかのplanのみ登録、他はNULLとする
// DialogFragment を継承したAlertDialogFragmentのインスタンス
            // DialogFragment を継承したAlertDialogFragmentのインスタンス
            val dialogFragment = AlertDialogFragment()
            dialogFragment.setlistener(this)
            // DialogFragmentの表示
            // DialogFragmentの表示
            dialogFragment.show(supportFragmentManager, "test alert dialog")
//                AlertDialog.Builder(this) // FragmentではActivityを取得して生成
//                    .setMessage("予定を追加してください。")
//                    .setView(view)
//                    .setPositiveButton(
//                        "Ok",
//                        { dialogInterface, p ->
//                            //pl= plan.text.toString()
//                            var tr: Travel = Travel("empty", "empty")
//                            addData(db,text1!!,pl,tr)
//                            //db.collection(text1!!).document(pl).set(tr)
//                            text_mu.add(pl)//text_muに追加
//                            adapter.add(pl)//
//                        })
//                    .setNegativeButton("cancel", null)
//                    .show()
                Log.d("rrrrrrrrrrrrrrrr", text3.toString())
            }

        modoru.setOnClickListener{
            finish()
        }

    }

    override fun onDialogPositiveClick(dialog: String) {
        Log.d("kkkkkkkkkk", dialog)
                           var tr: Travel = Travel("empty", "empty","empty")
                           addData(db,text1!!,dialog,tr)
                           //db.collection(text1!!).document(pl).set(tr)
                           text_mu.add(dialog)//text_muに追加
                          adapter.add(dialog)//
    }

}

class AlertDialogFragment : DialogFragment() {
    open interface SampleDialogListener {
        fun onDialogPositiveClick(dialog: String)
    }

    private var listener: SampleDialogListener? = null

    fun setlistener(listener: SampleDialogListener){
        this.listener=listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alert = AlertDialog.Builder(requireContext())
        val view: View = layoutInflater.inflate(R.layout.editdaialog, null)
        // タイトル

        var plan = EditText(requireContext())
        var pl = ""
        val db = FirebaseFirestore.getInstance()
        alert
            .setMessage("予定を追加してください。")
            .setView(plan)
            .setPositiveButton(

                "Ok",
                { dialogInterface, p ->
                    pl= plan.text.toString()
                    var tr: Travel = Travel("empty", "empty","empty")
                    listener?.onDialogPositiveClick(pl);
//                    addData(db,text1!!,pl,tr)
//                    db.collection(text1!!).document(pl).set(tr)
//                    text_mu.add(pl)//text_muに追加
//                    adapter.add(pl)//
                })
            .setNegativeButton("cancel", null)
//                .show()


        return alert?.create()!!
    }

}

fun getTravel(db:FirebaseFirestore,collection:String,document:String):Travel{
    val travel :Travel = Travel("empty", "empty","empty")
    db.collection(collection)
        .document(document)
        .get()
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val document = task.result
                if (document != null && document.data != null) {
                    Log.d(TAG, "getData")
                    Log.d(TAG, "DocumentSnapshot data: " + document.data?.get("startTime"))
                    Log.d(TAG, "DocumentSnapshot data: " + document.data?.get("endTime"))
                    val travel = Travel(document.data?.get("startTime").toString(),document.data?.get("endTime").toString(),document.data?.get("place").toString())
                } else {
                    Log.d(TAG, "No such document")
                }
            } else {
                Log.d(TAG, "get failed with " + task.exception)
            }
        }
        .addOnFailureListener { e -> Log.d(TAG, "Error adding document" + e)}
    return travel
}







