package com.example.jobapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.jobapp.R

class PhotoJobAdapter(private val images: List<PhotoJob>) : RecyclerView.Adapter<PhotoJobAdapter.ViewHolder>() {
    inner class ViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemImage: ImageView = itemView.findViewById(R.id.img_photo_job)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo_job,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageItem = images[position]
        holder.itemImage.setImageResource(imageItem.resourceId)
    }

    override fun getItemCount(): Int = images.size


}
//class PhotoJobAdapter(private val images: IntArray) : RecyclerView.Adapter<PhotoJobAdapter.ViewHolder>() {
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val imageView: ImageView = itemView.findViewById(R.id.imageView)
//    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_viewpager, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.imageView.setImageResource(images[position])
//    }
//
//    override fun getItemCount(): Int= images.size
//
//}
