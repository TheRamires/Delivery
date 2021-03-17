package com.example.deliverykotlin.components.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.deliverykotlin.components.menu.adapter.BrandRecyclerAdapter
import com.example.deliverykotlin.components.menu.adapter.TypeRecyclerAdapter
import com.example.deliverykotlin.databinding.FragmentSection2Binding

class Section2Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding= FragmentSection2Binding.inflate(inflater)
        val view=binding.root
        val viewModel= ViewModelProvider(requireActivity()).get(MenuViewModel::class.java)

        var resyclerView= binding.recycler
        viewModel.getSection2Live().observe(viewLifecycleOwner, {list->
            var adapter= TypeRecyclerAdapter(list)
            resyclerView.adapter=adapter
        })

        return view
    }
}