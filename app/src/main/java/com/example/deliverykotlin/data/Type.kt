package com.example.deliverykotlin.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Type (
    @PrimaryKey
    val id:Int,
    val name:String
    //val img: String,
)