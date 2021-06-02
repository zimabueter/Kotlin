package com.example.android.shualeduri2.database

import com.example.android.shualeduri2.Users


interface UsersFetchListener {
    fun ALLusers(users: List<Users>)
    fun users(user: Users)
    fun onHideDialog()
}