package com.example.viewpager.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.viewpager.R


class SecondFragment : Fragment(R.layout.fragment_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        view.findViewById<Button>(R.id.button2).setOnClickListener {
            with(sharedPref.edit()) {
                putString("name", view.findViewById<TextView>(R.id.setName).text.toString())
                putString("surname", view.findViewById<TextView>(R.id.setSurname).text.toString())
                putInt(
                    "age",
                    Integer.parseInt(view.findViewById<TextView>(R.id.setAge).text.toString())
                )
                putString("imageUrl", view.findViewById<TextView>(R.id.imageUrl).text.toString())
                apply()
            }

        }


    }

}