package com.example.homework

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeWork_14 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work_14)

        val emailEditText: EditText = findViewById(R.id.editTextEmail)
        val messageEditText: EditText = findViewById(R.id.editTextMessage)
        val sendButton: Button = findViewById(R.id.buttonSend)

        sendButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val message = messageEditText.text.toString()

            if (email.isNullOrEmpty() || message.isNullOrEmpty()) {
                Toast.makeText(this, "Please enter both email and message", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                putExtra(Intent.EXTRA_SUBJECT, "Subject")
                putExtra(Intent.EXTRA_TEXT, message)
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }
}