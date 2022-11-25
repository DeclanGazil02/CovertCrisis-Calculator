package com.example.covertcrisis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.covertcrisis.databinding.ActivityFirstMessagingBinding
import com.example.covertcrisis.databinding.ActivitySignUpBinding
import com.example.covertcrisis.databinding.ActivitySixthMessagingBinding

class SixthMessagingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySixthMessagingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySixthMessagingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, MessagingActivity::class.java)
            startActivity(intent)
        }
    }
}