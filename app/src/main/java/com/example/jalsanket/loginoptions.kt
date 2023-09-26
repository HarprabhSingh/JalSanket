package com.example.jalsanket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class loginoptionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginoptions)

        val btnExistingUser = findViewById<Button>(R.id.btnExistingUser)
        val btnNewUser = findViewById<Button>(R.id.btnNewUser)

        btnExistingUser.setOnClickListener {
            // Handle Existing User button click (e.g., navigate to existing user login activity)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnNewUser.setOnClickListener {
            // Handle New User button click (e.g., navigate to new user registration activity)
            val intent = Intent(this, NewUserRegistrationActivity2::class.java)
            startActivity(intent)
        }
    }
}