package com.example.android.shualeduri2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UsersAdapter(private val listener: UsersClickListener) :
    RecyclerView.Adapter<UsersAdapter.Holder>() {
    private var list: MutableList<Users> = mutableListOf()

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val users: Users = list[position]
        holder.name.text = users.name
        holder.mail.text = users.email
        holder.usernames.text = users.username

    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, null, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addUser(user: Users) {
        list.add(user)
        notifyDataSetChanged()
    }

    fun updateAdapter(newList: List<Users>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    fun getSelectedUser(position: Int): Users {
        return list[position]
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val name: TextView = itemView.findViewById(R.id.textView)
        val usernames: TextView = itemView.findViewById(R.id.getUsername)
        val mail: TextView = itemView.findViewById(R.id.getEmail)


        init {
            itemView.setOnClickListener(this)


        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)

            }
        }
    }


    interface UsersClickListener {
        fun onItemClick(position: Int)
    }


}
