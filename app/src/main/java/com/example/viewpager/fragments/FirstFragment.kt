package com.example.viewpager.fragments

import android.content.Context
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.viewpager.R
import com.squareup.picasso.Picasso


class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onResume() {
        super.onResume()
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        val name = sharedPref.getString("name", "Enter Name")
        val age = sharedPref.getInt("age", 0)
        val surname = sharedPref.getString("surname", "Enter Surname")
        val url = sharedPref.getString("imageUrl", "Enter Image Url")
        view?.findViewById<TextView>(R.id.name)?.text = name
        view?.findViewById<TextView>(R.id.age)?.text = age.toString()
        view?.findViewById<TextView>(R.id.surname)?.text = surname
        Picasso.get().load(url).into(view?.findViewById(R.id.image))

    }


}