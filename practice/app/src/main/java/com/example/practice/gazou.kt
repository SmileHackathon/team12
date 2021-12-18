package com.example.practice


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.net.Uri
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.activity.result.contract.ActivityResultContracts


class gazou : AppCompatActivity() {

    private lateinit var photoAdapter: PhotoAdapter
    private var photoList = mutableListOf<Uri>()
    private lateinit var recyclerView: RecyclerView

    private var image_launchar =
        registerForActivityResult(ActivityResultContracts.OpenMultipleDocuments()) {
            recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
            photoAdapter = PhotoAdapter(applicationContext)
            recyclerView.adapter = photoAdapter
            photoAdapter.setPhotoList(it)
            Log.d("aaaaa", it.toString())
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gazou)


        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val pictureButton: Button = findViewById<Button>(R.id.photoadd_button) //画面遷移用のボタンの取得
        pictureButton.setOnClickListener {
            image_launchar.launch(arrayOf("image/*"))
        }
    }
}
