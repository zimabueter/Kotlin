package com.example.myapplication.api.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserData(
    @SerializedName("id")
    val id: Int,

    @SerializedName("first_name")
    val first_name: String,

    @SerializedName("last_name")
    val last_name: String?,

    val email: String?,

    @SerializedName("avatar")
    val avatar: String?
) : Serializable