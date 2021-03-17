package com.example.deliverykotlin.components.menu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.deliverykotlin.Loger
import com.example.deliverykotlin.R
import com.example.deliverykotlin.data.Brand
import com.example.deliverykotlin.databinding.ItemSection1Binding

class BrandRecyclerAdapter(private val values: List<Brand>) :
    RecyclerView.Adapter<BrandRecyclerAdapter.MyViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding= ItemSection1Binding.inflate(inflater, parent, false)

        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding?.setParam(values[position])

        holder.itemView.setOnClickListener { v ->
            Navigation.findNavController(v).popBackStack()
        }

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ItemSection1Binding?=null

        init {
            binding= DataBindingUtil.bind(itemView)
        }
    }
}