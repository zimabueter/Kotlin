package com.example.android.shualeduri2.network

import com.example.android.shualeduri2.Todo
import com.example.android.shualeduri2.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetroService {
    @GET("users")
    fun getUsers(@Query("page") page: Int): Call<List<Users>>

    @GET("users/{userId}/todos")
    fun getUserInfo(@Path("userId") userId: Long): Call<List<Todo>>
}