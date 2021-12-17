package com.example.smidule

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
//import kotlinx.android.synthetic.main.photo_layout.view.*
//import kotlinx.android.synthetic.main.activity_main.*



class PhotoAdapter (var context: Context) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>(){
    var photoList = emptyList<Uri>()

    internal fun setPhotoList(photoList: List<Uri>){
        this.photoList = photoList
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var image: ImageView = itemView.findViewById(R.id.image)

//        init{
//            image = itemView.findViewById(R.id.imageView7)
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapter.ViewHolder{
        var view = LayoutInflater.from(parent.context).inflate(R.layout.photo_view, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: PhotoAdapter.ViewHolder, position: Int){
        var data = photoList[position]

        holder.image.setImageURI(data)
    }

    override fun getItemCount() = photoList.size
}