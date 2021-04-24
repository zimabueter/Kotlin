package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondActivity : AppCompatActivity() {
    private lateinit var ageEditText: EditText
    private lateinit var finishButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        ageEditText = findViewById(R.id.ageEditText)
        finishButton = findViewById(R.id.finishButton)
        val name = intent.extras?.getString("NAME")
        val mail = intent.extras?.getString("MAIL")
        finishButton.setOnClickListener {
            val ageText: String = ageEditText.text.toString()

            if (ageText.isEmpty())
                return@setOnClickListener
            val age: Int = ageText.toInt()
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("NAME",name).putExtra("AGE",age).putExtra("MAIL",mail)
            startActivity(intent)


        }



    }
}