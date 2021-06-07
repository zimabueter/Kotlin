package com.example.myapplication.api.dto

import com.google.gson.annotations.SerializedName


data class DataResponse(
    @SerializedName("page")
    val page: Int,

    @SerializedName("per_page")
    val per_page: Int,

    @SerializedName("total")
    val total: Int,

    @SerializedName("total_pages")
    val total_pages: Int,


    @SerializedName("data")
    var data: List<UserData>? = null,
    var detailsData: UserData
)


