package com.example.android.shualeduri2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.android.shualeduri2.database.App
import com.example.android.shualeduri2.database.AppDatabase
import com.example.android.shualeduri2.database.UsersFetchListener
import com.example.android.shualeduri2.network.RetroInstance
import com.example.android.shualeduri2.network.RetroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), UsersAdapter.UsersClickListener, UsersFetchListener,
    SwipeRefreshLayout.OnRefreshListener {
    private lateinit var refreshLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView
    private val usersAdapter: UsersAdapter = UsersAdapter(this)
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        refreshLayout = findViewById(R.id.refresh)
        refreshLayout.setOnRefreshListener(this)
        getFeed()
        db = App.instance.db
        recyclerView = findViewById(R.id.list_item)
        recyclerView.adapter = usersAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        App.instance.db.getUsersDao().getAllUsers().let { usersAdapter.updateAdapter(it) }

    }

    private fun getFeed() {
        val client: RetroService = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call: Call<List<Users>> = client.getUsers(1)
        call.enqueue(object : Callback<List<Users>> {
            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                val users: List<Users>? = response.body()
                users?.let { usersAdapter.updateAdapter(it) }
                for (i in users?.indices!!) {
                    val user: Users = users[i]
                    App.instance.db.getUsersDao().insert(user)
                }

            }

            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "No internet connection", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }

    override fun onItemClick(position: Int) {
        val selectedUser: Users = usersAdapter.getSelectedUser(position)
        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
        intent.putExtra("selectedUser", selectedUser)

        startActivity(intent)
    }

    override fun ALLusers(users: List<Users>) {
        usersAdapter.updateAdapter(users)
    }

    override fun users(user: Users) {
        usersAdapter.addUser(user)
    }

    override fun onHideDialog() {
    }

    override fun onRefresh() {
        getFeed()
        refreshLayout.isRefreshing = false
    }

}