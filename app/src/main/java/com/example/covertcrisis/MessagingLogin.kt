package com.example.covertcrisis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.covertcrisis.databinding.ActivityMessagingLoginBinding
import com.example.covertcrisis.databinding.ActivitySignUpBinding
import kotlinx.android.synthetic.main.activity_interior.*

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