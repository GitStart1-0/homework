package com.example.homework

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class mainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homework_13)

        val emailButton: Button = findViewById(R.id.button_email)
        val phoneButton: Button = findViewById(R.id.button_phone)

        emailButton.setOnClickListener {
            Toast.makeText(this, "Довільне повідомлення", Toast.LENGTH_SHORT).show()
        }

        phoneButton.setOnClickListener {
            Toast.makeText(this, "Довільне повідомлення", Toast.LENGTH_SHORT).show()
        }
    }
}