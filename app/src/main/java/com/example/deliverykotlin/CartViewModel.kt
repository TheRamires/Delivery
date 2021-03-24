package com.example.deliverykotlin

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import com.example.deliverykotlin.components.menu.adapter.EntityRecyclerAdapter
import com.example.deliverykotlin.data.MyEntity

class CartViewModel: ViewModel() {
    var countDownTimer: CountDownTimer?=null

    fun getCountDownTimerVisible (entity: MyEntity, adapter: EntityRecyclerAdapter){
        countDownTimer=object: CountDownTimer(2000, 1000){
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                entity.counterVisible=false
                adapter.notifyItemChanged(entity.id)
                countDownTimer=null
            }
        }
    }
}