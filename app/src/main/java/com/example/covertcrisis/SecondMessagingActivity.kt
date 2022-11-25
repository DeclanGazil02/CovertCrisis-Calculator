package com.example.covertcrisis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.covertcrisis.databinding.ActivityFirstMessagingBinding
import com.example.covertcrisis.databinding.ActivitySecondMessagingBinding

class SecondMessagingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondMessagingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondMessagingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, ThirdMessagingActivity::class.java)
            startActivity(intent)
        }
    }
}