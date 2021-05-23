package com.example.android.kotlin_general


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val icLogo: ImageView = findViewById(R.id.ic_logo)
        icLogo.startAnimation(AnimationUtils.loadAnimation(this, R.anim.splash_in))
        Handler(Looper.myLooper()!!).postDelayed({
            icLogo.startAnimation(AnimationUtils.loadAnimation(this, R.anim.splash_out))
            Handler(Looper.myLooper()!!).postDelayed({
                icLogo.visibility = View.GONE
                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            }, 500)
        }, 1500)

    }
}
