package com.example.android.shualeduri2.database

import androidx.room.*
import com.example.android.shualeduri2.Users

@Dao
interface UsersDao {
    @Query("SELECT * FROM USERS")
    fun getAllUsers(): List<Users>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: Users)

    @Delete
    fun deleteUser(user: Users)

    @Query("DELETE FROM USERS")
    fun deleteAll()
}
