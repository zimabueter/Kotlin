package com.example.android.firebaseauth.views

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.android.firebaseauth.HomeActivity
import com.example.android.firebaseauth.R
import com.example.android.firebaseauth.extensions.Extensions.toast
import com.example.android.firebaseauth.utils.FirebaseUtils.firebaseAuth
import com.example.android.firebaseauth.utils.FirebaseUtils.firebaseUser
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccountActivity : AppCompatActivity() {
    private lateinit var userEmail: String
    private lateinit var userPassword: String
    private lateinit var createAccountInputsArray: Array<EditText>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        createAccountInputsArray = arrayOf(etEmail, etPassword, etConfirmPassword)
        btnCreateAccount.setOnClickListener {
            signIn()
        }

        btnSignIn2.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            toast("please sign into your account")
            finish()
        }
    }


    override fun onStart() {
        super.onStart()
        val user: FirebaseUser? = firebaseAuth.currentUser
        user?.let {
            startActivity(Intent(this, HomeActivity::class.java))
            toast("welcome back")
        }
    }

    private fun isValidPasswordFormat(): Boolean {
        val numPattern = Regex("[0-9]")
        val pattern = Regex("[a-zA-z]")

        return pattern.containsMatchIn(
            etPassword.text.toString().trim()
        ) && numPattern.containsMatchIn(etPassword.text.toString().trim())
    }

    private fun notEmpty(): Boolean = etEmail.text.toString().trim().isNotEmpty() &&
            etPassword.text.toString().trim().isNotEmpty() &&
            etConfirmPassword.text.toString().trim().isNotEmpty()

    private fun identicalPassword(): Boolean {
        var identical = false
        if (notEmpty() &&
            etPassword.text.toString().trim() == etConfirmPassword.text.toString()
                .trim() && etPassword.text.toString().trim().length >= 8 && isValidPasswordFormat()
        ) {
            identical = true
        } else if (!notEmpty()) {
            createAccountInputsArray.forEach { input ->
                if (input.text.toString().trim().isEmpty()) {
                    input.error = "${input.hint} is required"
                }
            }
        } else if (etPassword.text.toString().trim().length < 8) {
            toast("password is too short")
        } else if (!isValidPasswordFormat()) {
            toast("Missing number or letter")
        } else {
            toast("passwords are not matching !")
        }
        return identical
    }

    private fun signIn() {
        if (identicalPassword()) {
            userEmail = etEmail.text.toString().trim()
            userPassword = etPassword.text.toString().trim()

            firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        toast("created account successfully !")
                        sendEmailVerification()
                        startActivity(Intent(this, HomeActivity::class.java))
                        finish()
                    } else {
                        toast("failed to Authenticate !")
                    }
                }
        }
    }


    private fun sendEmailVerification() {
        firebaseUser?.let {
            it.sendEmailVerification().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    toast("email sent to $userEmail")
                }
            }
        }
    }
}