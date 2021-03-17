package com.example.deliverykotlin.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MyEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    //val img: String,
    val brand: String,
    val name: String,
    val description: String,
    val price: String,
    val param1:String,
)