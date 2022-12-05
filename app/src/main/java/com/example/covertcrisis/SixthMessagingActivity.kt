package com.example.covertcrisis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.covertcrisis.databinding.ActivityFirstMessagingBinding
import com.example.covertcrisis.databinding.ActivitySignUpBinding
import com.example.covertcrisis.databinding.ActivitySixthMessagingBinding
import kotlinx.android.synthetic.main.activity_interior.*

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

        bottomNavigationView.menu.getItem(0).setOnMenuItemClickListener{ //home
            val intent = Intent(this, InteriorActivity::class.java)
            startActivity(intent)
            true
        }
        bottomNavigationView.menu.getItem(1).setOnMenuItemClickListener{ //home
            val intent = Intent(this, MessagingLogin::class.java)
            startActivity(intent)
            true
        }
        bottomNavigationView.menu.getItem(2).setOnMenuItemClickListener{ //home
            val intent = Intent(this, ResourceShareLocationActivity::class.java)
            startActivity(intent)
            true
        }

        bottomNavigationView.menu.getItem(1).setChecked(true)
    }
}