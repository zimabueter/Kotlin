package com.example.android.shualeduri2.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android.shualeduri2.Users

@Database(entities = [Users::class], version = 5)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getUsersDao(): UsersDao
}