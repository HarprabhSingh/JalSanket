package com.example.jalsanket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {


    private lateinit var editTextPhoneNumber: TextInputEditText
    private lateinit var editTextPassword: TextInputEditText
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)

        buttonLogin.setOnClickListener(View.OnClickListener {
            // Retrieve user-entered phone number and password
            val phoneNumber = editTextPhoneNumber.text.toString()
            val password = editTextPassword.text.toString()

            // TODO: Implement your authentication logic here (e.g., validate credentials)

            // For demonstration purposes, show a toast message
            if (isValidCredentials(phoneNumber, password)) {
                // Successful login
                Toast.makeText(this@LoginActivity, "Login successful!", Toast.LENGTH_SHORT).show()
                // Redirect to another activity (e.g., MainActivity)
                val intent = Intent(this@LoginActivity, MapsActivity::class.java)
                startActivity(intent)
            } else {
                // Failed login
                Toast.makeText(this@LoginActivity, "Login failed. Please check your credentials.", Toast.LENGTH_SHORT).show()
            }
        })
    }

    // Example of credential validation; replace this with your authentication logic
    private fun isValidCredentials(phoneNumber: String, password: String): Boolean {
        return phoneNumber == "9289465034" && password == "password"
    }
}