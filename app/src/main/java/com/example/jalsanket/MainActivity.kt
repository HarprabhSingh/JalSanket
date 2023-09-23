package com.example.jalsanket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myxButton = findViewById<Button>(R.id.button2)


        myxButton.setOnClickListener {
            // Define the action you want to perform when the button is clicked
            val intent = Intent(this, loginoptionsActivity::class.java)
            startActivity(intent)
        }

    }
}
