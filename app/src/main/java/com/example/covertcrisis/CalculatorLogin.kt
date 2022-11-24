package com.example.covertcrisis

import android.content.Intent
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.covertcrisis.databinding.ActivityCalculatorLoginBinding
import com.example.covertcrisis.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class CalculatorLogin : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPref.edit()


        if(sharedPref.getBoolean("Initialized3", false)){//if already set password
            val intent = Intent(this@CalculatorLogin, MainActivity::class.java)
            startActivity(intent)
        }

        binding.equalsButton.setOnClickListener {
            if(binding.workingsTextView.text.length == 8){
                //save password in shared preferences
                binding.apply {
                    val passcode = binding.workingsTextView.text.toString()
                    editor.apply {
                        putString("passcode", passcode)
                        putBoolean("Initialized3", true)
                        apply()
                        //now go to real calculator
                        val intent = Intent(this@CalculatorLogin, MainActivity::class.java)
                        startActivity(intent)
                    }
                }
            }else{
                Toast.makeText(this, "Passcode must be 8 Digits Long", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun operationAction(view: View) {
        return
    }
    fun numberAction(view: View) {
        if(view is Button && binding.workingsTextView.text.length < 8){
            binding.workingsTextView.append(view.text)
        }
    }
    fun allClearAction(view: View) {
        binding.workingsTextView.text = ""
    }
    fun backSpaceAction(view: View) {
        val length = binding.workingsTextView.text.length
        if(length > 0) {
            binding.workingsTextView.text =
                binding.workingsTextView.text.substring(0, length - 1) //erase last digit
        }

    }
}