package com.example.myapplication.api

import com.example.myapplication.api.dto.DataResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ReqResService {

    @GET("users")
    fun getUsers(@Query("page") page: Int): Call<DataResponse>


}