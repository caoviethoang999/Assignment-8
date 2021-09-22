package com.example.hoangcv2_assiagnment.adapter

import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hoangcv2_assiagnment.*
import com.example.hoangcv2_assiagnment.model.Category
import java.util.*


class CategoryAdapter(var onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<CategoryAdapter.ItemViewHolder>() {
    var list: MutableList<Category>
    fun getAll(list: MutableList<Category>?) {
        this.list = list!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_custom_view, parent, false)
        return ItemViewHolder(v)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val itemCategory: Category = list[position]
        holder.txtTitle1.text = itemCategory.categoryName
        val photo = ImageRequestAsk().execute(itemCategory.categoryImage).get()!!
        holder.imgViewItem.setImageBitmap(photo)
        val background =ImageRequestAsk().execute(itemCategory.categoryBackground).get()!!
        holder.imgViewItem.background=
            BitmapDrawable(holder.itemView.context.resources,background)
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(holder.adapterPosition,Status.CATEGORY)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitle1: TextView = itemView.findViewById(R.id.textViewItem1)
        var imgViewItem: ImageView = itemView.findViewById(R.id.imageViewItem1)
    }

    init {
        list = ArrayList<Category>()
    }
}