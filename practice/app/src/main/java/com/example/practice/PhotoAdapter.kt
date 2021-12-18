package com.example.practice

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView


class PhotoAdapter (var context: Context) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>(){
    var photoList = emptyList<Uri>()

    internal fun setPhotoList(photoList: List<Uri>){
        this.photoList = photoList
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var image: ImageView = itemView.findViewById(R.id.image)
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
