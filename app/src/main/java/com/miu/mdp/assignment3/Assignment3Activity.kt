package com.miu.mdp.assignment3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.databinding.ActivityAssignment3Binding

class Assignment3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityAssignment3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssignment3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSignIn.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        binding.btnShopping.setOnClickListener {
            startActivity(Intent(this, ShoppingActivity::class.java))
        }
        binding.btnCalculator.setOnClickListener {
            startActivity(Intent(this, CalculatorActivity::class.java))
        }
    }
}