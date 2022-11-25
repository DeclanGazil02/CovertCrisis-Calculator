package com.example.covertcrisis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.covertcrisis.databinding.ActivityFifthMessagingBinding
import com.example.covertcrisis.databinding.ActivityFirstMessagingBinding

class FifthMessagingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFifthMessagingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifthMessagingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, SixthMessagingActivity::class.java)
            startActivity(intent)
        }
    }
}