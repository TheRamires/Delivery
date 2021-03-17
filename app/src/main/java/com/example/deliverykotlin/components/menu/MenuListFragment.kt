package com.example.deliverykotlin.components.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.deliverykotlin.R
import com.example.deliverykotlin.adapters.RecyclerSectionItemDecoration
import com.example.deliverykotlin.components.menu.adapter.EntityRecyclerAdapter
import com.example.deliverykotlin.data.MyEntity
import com.example.deliverykotlin.databinding.FragmentMenuListBinding

class MenuListFragment : Fragment() {

    private lateinit var viewModel: MenuViewModel
    private lateinit var actionBar:ActionBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentMenuListBinding.inflate(inflater)
        val view =binding.root
        val customView=inflater.inflate(R.layout.custom_button_menu, null).also {
            it.findViewById<TextView>(R.id.btn_menu).text="Sections"
            it.setOnClickListener { v->
               Navigation.findNavController(view).navigate(R.id.action_navigation_menu_to_menuConteinerFragment2)
            }
        }
        actionBar= (activity as AppCompatActivity)!!.supportActionBar!!
        actionBar?.setCustomView(customView)
        actionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)

        viewModel=ViewModelProvider(requireActivity()).get(MenuViewModel::class.java)
        viewModel.getMenuList()

        val recyclerView=binding.recycler
        viewModel.menuLive.observe(viewLifecycleOwner, { list ->
            val recyclerSectionItemDecoration = getDecorForSection1(list)
            val adapter = EntityRecyclerAdapter(list)
            recyclerView.apply {
                this?.adapter = adapter
                this.addItemDecoration(recyclerSectionItemDecoration!!)
            }
        })

        return view
    }

    fun getDecorForSection1(list: List<MyEntity>): RecyclerSectionItemDecoration? {
        return RecyclerSectionItemDecoration(
            requireContext().resources
                .getDimensionPixelSize(R.dimen.recycler_section_header_height),
            true,  // true for sticky, false for not
            object : RecyclerSectionItemDecoration.SectionCallback {
                override fun isSection(position: Int): Boolean {
                    return (position == 0
                            || list[position] //.getLastName()
                        .brand.get(0) !== list[position - 1] //.getLastName()
                        .brand.get(0))
                }

                override fun getSectionHeader(position: Int): CharSequence {
                    return list[position] //.getLastName()
                        .brand
                    //.subSequence(0, 3); //.subSequence(0, 1);   //•установление заголовка
                }
            })
    }
}