package com.example.covertcrisis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.covertcrisis.databinding.ActivityFirstMessagingBinding
import com.example.covertcrisis.databinding.ActivityThirdMessagingBinding

class ThirdMessagingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdMessagingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdMessagingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, FourthMessagingActivity::class.java)
            startActivity(intent)
        }
    }
}