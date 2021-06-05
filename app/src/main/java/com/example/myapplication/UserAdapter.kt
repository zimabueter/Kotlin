package com.example.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.api.dto.User

class UserAdapter(private val listener: UserClickListener) :
    RecyclerView.Adapter<UserAdapter.Holder>() {
    private var list: MutableList<User> = mutableListOf()

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val user: User = list[position]
        holder.mail.text = user.email
        holder.firstName.text = user.firstName.toString()
        holder.lastName.text = user.lastName.toString()

    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list, null, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addUser(user: User) {
        list.add(user)
        notifyDataSetChanged()
    }

    fun updateAdapter(newList: List<User>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    fun reset() {
        list.clear()
        notifyDataSetChanged()
    }

    fun getSelectedUser(position: Int): User {
        return list[position]
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val mail: TextView = itemView.findViewById(R.id.mail)
        val firstName: TextView = itemView.findViewById(R.id.firstname)
        val lastName: TextView = itemView.findViewById(R.id.lastname)


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


    interface UserClickListener {
        fun onItemClick(position: Int)
    }


}