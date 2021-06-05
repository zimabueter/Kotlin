package com.example.myapplication.api.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class User(

    val id: Long?,

    var email: String?,

    @SerializedName("first_name")
    var firstName: String?,

    @SerializedName("last_name")
    var lastName: String?,

    var avatar: String?

): Serializable {
}

//data class ReqResData<T>(
//
//    val page: Int?,
//
//    val data: T
//
//)