package com.example.tugas4pamdatastatic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (private val item: List<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val namaTampil: TextView = itemView.findViewById(R.id.namaTampil)
        val deskripsi: TextView = itemView.findViewById(R.id.deskripsi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = item[position]
        holder.namaTampil.text = item.nama
        holder.deskripsi.text = item.deskripsi
    }

    override fun getItemCount() = item.size
}