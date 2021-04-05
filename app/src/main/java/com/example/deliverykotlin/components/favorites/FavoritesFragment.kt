package com.example.deliverykotlin.components.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.swipe.util.Attributes
import com.example.deliverykotlin.CartViewModel
import com.example.deliverykotlin.R
import com.example.deliverykotlin.components.favorites.adapter.FavoritesRecyclerView
import com.example.deliverykotlin.components.favorites.adapter.FavoritesRecyclerView.*
import com.example.deliverykotlin.components.menu.adapter.EntityRecyclerAdapter
import com.example.deliverykotlin.data.MyEntity
import com.example.deliverykotlin.databinding.FragmentFavoritesBinding
import org.koin.android.viewmodel.ext.android.viewModel

class FavoritesFragment : Fragment(), OnPositionClickListener, OnCounterClickListener {
    private val viewModel : FavoritesViewModel by viewModel()
    private val cartViewModel : CartViewModel by viewModel()
    private lateinit var recyclerAdapter: FavoritesRecyclerView
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar.apply {
            this?.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE)
        }

        val binding =FragmentFavoritesBinding.inflate(inflater)
        binding.fragment=this
        val view=binding.root

        recyclerView=binding.recycler

        viewModel.getFavoritesList()

        viewModel.favoritesListLive.observe(viewLifecycleOwner, {
            if (it.isEmpty()) {
                recyclerView.setVisibility(View.GONE)
                binding.emptyView.setVisibility(View.VISIBLE)
            } else {
                recyclerView.setVisibility(View.VISIBLE)
                binding.emptyView.setVisibility(View.GONE)
            }

            recyclerAdapter = FavoritesRecyclerView(requireContext(), it, viewModel)
            recyclerAdapter.also {
                it.setPostionClickListener(this)
                it.setCounterClickListener(this)
            }
            recyclerView.adapter = recyclerAdapter
            recyclerAdapter.notifyDataSetChanged()

            recyclerAdapter.setMode(Attributes.Mode.Single)

            recyclerView.setAdapter(recyclerAdapter)

            /*recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    Log.e("RecyclerView", "onScrollStateChanged")
                }

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                }
            })*/
        })

        return view
    }

    override fun OnPositionClick(view: View, id: Int) {
        var bundle=Bundle()
        bundle.putInt("id",id)
        view.findNavController().navigate(R.id.action_navigation_menu_to_detailFragment, bundle)
    }

    override fun OnCounterClick(view: View, entity: MyEntity, position: Int) {/*
        when(view.id){
            R.id.price_button -> {
                val added=entity.addPostion()
                if (added){
                    //count
                }
                entity.counterVisible = true
                cartViewModel.getCountDownTimerVisible(entity,recyclerAdapter, position)
                cartViewModel.startTimer()
            }
            R.id.plus_button->{
                val plus=entity.plusPosition()
                if (plus){
                    //count
                }
                cartViewModel.refreshTimer()
            }
            R.id.minus_button->{
                val minus=entity.minusPosition()
                if (minus){
                    //count
                }
                cartViewModel.refreshTimer()
            }
        }
        recyclerAdapter.notifyItemChanged(position)*/
    }
}