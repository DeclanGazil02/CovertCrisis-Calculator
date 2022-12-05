package com.example.covertcrisis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.covertcrisis.databinding.ActivityFifthMessagingBinding
import com.example.covertcrisis.databinding.ActivityInteriorBinding
import com.example.covertcrisis.databinding.ActivityResourceShareLocationBinding
import kotlinx.android.synthetic.main.activity_resource_share_location.*

class ResourceShareLocationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResourceShareLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResourceShareLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.location.setOnClickListener {
            val intent = Intent(this, ResourceActivity::class.java)
            startActivity(intent)
        }

        binding.dontShare.setOnClickListener {
            val intent = Intent(this, InteriorActivity::class.java)
            startActivity(intent)
        }
    }
}