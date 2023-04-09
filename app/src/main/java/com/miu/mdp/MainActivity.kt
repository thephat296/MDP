package com.miu.mdp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.assignment2.Assignment2Activity
import com.miu.mdp.assignment3.Assignment3Activity
import com.miu.mdp.assignment4.SignInActivity
import com.miu.mdp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAssignment2.setOnClickListener {
            startActivity(Intent(this, Assignment2Activity::class.java))
        }
        binding.btnAssignment3.setOnClickListener {
            startActivity(Intent(this, Assignment3Activity::class.java))
        }
        binding.btnAssignment4.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}