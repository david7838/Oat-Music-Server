package com.oatmusic.oat_music_server.web.model

//primary constructor
//data represent equals, hashcode, toString
data class Bank(
     val accountNumber: String,
     val trust: Double,
     val transactionFee: Int
) {


}