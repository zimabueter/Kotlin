package com.example.android.shualeduri2

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android.shualeduri2.network.RetroInstance
import com.example.android.shualeduri2.network.RetroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val client: RetroService = RetroInstance.getRetroInstance().create(RetroService::class.java)

        val todoText: TextView = findViewById(R.id.getTODO)
        val user: Users = intent.getSerializableExtra("selectedUser") as Users

        val call: Call<List<Todo>> = client.getUserInfo(user.id)
        call.enqueue(object : Callback<List<Todo>> {

            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                val info: List<Todo>? = response.body()
                for (i in info?.indices!!) {
                    todoText.text = info[i].toString()

                }

            }

            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                Toast.makeText(this@DetailsActivity, "Error", Toast.LENGTH_LONG)
                    .show()
            }


        })
    }
}