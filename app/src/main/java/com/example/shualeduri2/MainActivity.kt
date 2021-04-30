package com.example.shualeduri2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var cardNumber: EditText
    private lateinit var fullName: EditText
    private lateinit var cardType: EditText
    private lateinit var cvvCode: EditText
    private lateinit var expirationMM: EditText
    private lateinit var expirationYY: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        cardNumber = findViewById(R.id.cardNumber)
        cardType = findViewById(R.id.cardType)
        cvvCode = findViewById(R.id.cvv)
        expirationMM = findViewById(R.id.expirationMonth)
        expirationYY = findViewById(R.id.expirationYear)
        fullName = findViewById(R.id.fullName)

        button.setOnClickListener {


            if (cardType.text.toString() == "Visa" || cardType.text.toString() == "Amex" || cardType.text.toString() == "MasterCard") {



            }else{
                cardType.error = "Card type is wrong"
                return@setOnClickListener
            }


            if (fullName.text.toString().isEmpty()) {
                fullName.error = "You must enter a name"
                return@setOnClickListener
            }

            if (cardType.text.toString() == "Visa" || cardType.text.toString() == "MasterCard") {
                if (cardNumber.text.toString().length != 16) {
                    cardNumber.error = "Card number is wrong"
                    return@setOnClickListener
                }
                if (cvvCode.text.toString().length != 3) {
                    cvvCode.error = "CVV code is incorrect"
                    return@setOnClickListener
                }
            }
                if (cardType.text.toString() == "Amex") {
                    if (cardNumber.text.toString().length != 15) {
                        cardNumber.error = "Card number is wrong"
                        return@setOnClickListener
                    }
                    if (cvvCode.text.toString().length != 4) {
                        cvvCode.error = "CVV code is incorrect"
                        return@setOnClickListener
                    }

            }

            return@setOnClickListener Toast.makeText(this@MainActivity, "Payment is successful", Toast.LENGTH_LONG).show()
        }

    }
}