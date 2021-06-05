package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.api.ReqResService
import com.example.myapplication.api.RetrofitClient
import com.example.myapplication.api.dto.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), UserAdapter.UserClickListener {
    private lateinit var recyclerView: RecyclerView
    private val userAdapter: UserAdapter = UserAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.items)
        recyclerView.adapter = userAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        getUsers()

    }


    private fun getUsers() {
        val client: ReqResService = RetrofitClient.getInstance().create(ReqResService::class.java)
        val call: Call<List<User>> = client.getUsers(1)
        call.enqueue(object : Callback<List<User>> {

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val users: List<User>? =response.body()
                users?.let { userAdapter.updateAdapter(it) }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "error", Toast.LENGTH_LONG).show()

            }
        })

    }

    override fun onItemClick(position: Int) {
    }

}