package com.example.covertcrisis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.covertcrisis.databinding.ActivityFirstMessagingBinding
import com.example.covertcrisis.databinding.ActivityFourthMessagingBinding

class FourthMessagingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthMessagingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthMessagingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, FifthMessagingActivity::class.java)
            startActivity(intent)
        }
    }
}