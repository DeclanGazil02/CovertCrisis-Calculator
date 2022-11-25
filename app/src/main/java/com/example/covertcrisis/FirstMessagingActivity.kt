package com.example.covertcrisis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.covertcrisis.databinding.ActivityFirstMessagingBinding
import com.example.covertcrisis.databinding.ActivityMessagingLoginBinding

class FirstMessagingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstMessagingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstMessagingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, SecondMessagingActivity::class.java)
            startActivity(intent)
        }
    }
}