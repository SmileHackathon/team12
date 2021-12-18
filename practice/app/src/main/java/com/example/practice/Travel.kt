package com.example.practice

import java.io.Serializable

data class Travel(
    //val plan : String = "",
    val startTime : String ,
    val endTime : String,
    val place : String
):Serializable