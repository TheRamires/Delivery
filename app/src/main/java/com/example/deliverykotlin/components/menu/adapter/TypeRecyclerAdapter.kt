package com.example.deliverykotlin.components.menu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.deliverykotlin.data.Type
import com.example.deliverykotlin.databinding.ItemSection2Binding

class TypeRecyclerAdapter (private val values: List<Type>) :
    RecyclerView.Adapter<TypeRecyclerAdapter.MyViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding= ItemSection2Binding.inflate(inflater,parent,false)

        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding?.setParam(values[position])
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ItemSection2Binding?=null

        init {
            binding= DataBindingUtil.bind(itemView)
        }
    }
}