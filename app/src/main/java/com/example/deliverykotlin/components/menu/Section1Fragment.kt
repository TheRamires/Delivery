package com.example.deliverykotlin.components.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.deliverykotlin.R
import com.example.deliverykotlin.components.menu.adapter.BrandRecyclerAdapter
import com.example.deliverykotlin.databinding.FragmentSection1Binding

class Section1Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentSection1Binding.inflate(inflater)
        val view=binding.root
        val viewModel=ViewModelProvider(requireActivity()).get(MenuViewModel::class.java)

        var resyclerView= binding.recycler

        viewModel.getSection1Live().observe(viewLifecycleOwner, {list->
            var adapter= BrandRecyclerAdapter(list, viewModel.paramFinding)
            resyclerView.adapter=adapter
            viewModel.param=Param.BRAND
        })
        return view
    }
}