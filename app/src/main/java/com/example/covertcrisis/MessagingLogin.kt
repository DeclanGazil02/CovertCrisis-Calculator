package com.example.covertcrisis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.covertcrisis.databinding.ActivityMessagingLoginBinding
import com.example.covertcrisis.databinding.ActivitySignUpBinding

class MessagingLogin : AppCompatActivity() {
    private lateinit var binding: ActivityMessagingLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessagingLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, FirstMessagingActivity::class.java)
            startActivity(intent)
        }
    }
}