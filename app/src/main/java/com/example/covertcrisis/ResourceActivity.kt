package com.example.covertcrisis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.covertcrisis.databinding.ActivityInteriorBinding
import com.example.covertcrisis.databinding.ActivityResourceBinding
import com.example.covertcrisis.databinding.ActivityResourceShareLocationBinding
import kotlinx.android.synthetic.main.activity_interior.*

class ResourceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResourceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loadMore.setOnClickListener {
            Toast.makeText(this, "All resources shown.", Toast.LENGTH_SHORT).show()
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

        bottomNavigationView.menu.getItem(2).setChecked(true)
    }
}