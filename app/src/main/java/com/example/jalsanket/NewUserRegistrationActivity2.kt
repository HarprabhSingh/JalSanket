package com.example.jalsanket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class NewUserRegistrationActivity2 : AppCompatActivity() {
    private lateinit var editTextFullName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonSignup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user_registration2)

        editTextFullName = findViewById(R.id.editTextFullName)
        editTextEmail = findViewById(R.id.editTextPhoneNumber)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonSignup = findViewById(R.id.buttonSignup)

        buttonSignup.setOnClickListener(View.OnClickListener {
            // Retrieve user-entered data
            val fullName = editTextFullName.text.toString()
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            // TODO: Implement your user registration logic here

            // For demonstration purposes, show a toast message
            Toast.makeText(this, "Sign up successful!", Toast.LENGTH_SHORT).show()

            // Redirect to another activity (e.g., MainActivity) after successful signup
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }
}