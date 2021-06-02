package com.example.android.shualeduri2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "USERS")
data class Users(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "USER_ID")
    var id: Long,
    var name: String,
    var username: String,
    var email: String
) : Serializable {
    constructor() : this(-1, "", "", "")
}
