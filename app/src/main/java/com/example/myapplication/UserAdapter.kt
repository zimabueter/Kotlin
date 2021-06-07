package com.example.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.api.dto.UserData

class UserAdapter(private val listener: UserClickListener) :
    RecyclerView.Adapter<UserAdapter.Holder>() {
    private var list: MutableList<UserData> = mutableListOf()

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val user: UserData = list[position]
        holder.mail.text = user.email
        holder.firstName.text = user.first_name
        holder.lastName.text = user.last_name.toString()

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



    fun updateAdapter(newList: List<UserData>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }


    fun getSelectedUser(position: Int): UserData {
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