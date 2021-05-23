package com.example.android.kotlin_general

import android.app.Application

class TodoApplication: Application() {
 lateinit var database:DBHandler
private set

    override fun onCreate() {
        super.onCreate()
        database= DBHandler(this)
    }
}