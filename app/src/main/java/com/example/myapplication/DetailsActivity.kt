package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.api.dto.UserData
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        getImage()
    }

    private fun getImage() {
        val url: ImageView = findViewById(R.id.url)
        val uData: UserData = intent.getSerializableExtra("selectedUser") as UserData
        Picasso.get().load(uData.avatar).into(url)

    }


}