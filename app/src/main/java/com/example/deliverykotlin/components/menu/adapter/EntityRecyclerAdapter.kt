package com.example.deliverykotlin.components.menu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.deliverykotlin.data.MyEntity
import com.example.deliverykotlin.databinding.ItemListBinding

class EntityRecyclerAdapter(private val values: List<MyEntity>) :
    RecyclerView.Adapter<EntityRecyclerAdapter.MyViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding=ItemListBinding.inflate(inflater,parent,false)

        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding?.setEntity(values[position])
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ItemListBinding?=null

        init {
            binding= DataBindingUtil.bind(itemView)
        }
    }
}