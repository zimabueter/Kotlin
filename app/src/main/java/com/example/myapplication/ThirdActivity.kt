package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    private lateinit var nameTextView: TextView
    private lateinit var ageTextView: TextView
    private lateinit var mailTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        nameTextView = findViewById(R.id.textView)
        ageTextView = findViewById(R.id.textView2)
        mailTextView = findViewById(R.id.textView3)
        nameTextView.text = intent.extras?.getString("NAME")
        ageTextView.text = intent.extras?.getInt("AGE").toString()
        mailTextView.text = intent.extras?.getString("MAIL")
    }
}