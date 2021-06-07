package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.api.ReqResService
import com.example.myapplication.api.RetrofitClient
import com.example.myapplication.api.dto.DataResponse
import com.example.myapplication.api.dto.UserData
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
        val call: Call<DataResponse> = client.getUsers(1)
        call.enqueue(object : Callback<DataResponse> {

            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {

                val users: List<UserData>? = response.body()?.data
                if (response.isSuccessful && users != null) {

                    users.let {
                        userAdapter.updateAdapter(it)
                    }
                }
            }

            override fun onFailure(call: Call<DataResponse>, t: Throwable) {

                Toast.makeText(this@MainActivity, "error", Toast.LENGTH_LONG).show()

            }
        })

    }

    override fun onItemClick(position: Int) {


        val selectedUser: UserData = userAdapter.getSelectedUser(position)
        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
        intent.putExtra("selectedUser", selectedUser)

        startActivity(intent)

    }

}