package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondPointFiveActivity : AppCompatActivity() {
    private lateinit var mailEditText: EditText
    private lateinit var nextButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_point_five)

        mailEditText = findViewById(R.id.mailEditText)
        nextButton = findViewById(R.id.nextButton2)
        val name = intent.extras?.getString("NAME")
        nextButton.setOnClickListener {
            val mail: String = mailEditText.text.toString()
            if (mail.isEmpty() || !mail.contains('@')) {
                return@setOnClickListener
            }

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("MAIL", mail).putExtra("NAME",name)
            startActivity(intent)

        }

    }
}