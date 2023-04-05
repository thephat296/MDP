package com.miu.mdp.assignment2

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.databinding.ActivityAssignment2Binding
import java.util.*

class Assignment2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityAssignment2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssignment2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val random = Random()
        val randomColor: () -> Int =
            { Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)) }
        binding.tvSetBackground.setOnClickListener {
            binding.root.setBackgroundColor(randomColor.invoke())
        }
        binding.ibLogo.setOnClickListener {
            it.setBackgroundColor(randomColor.invoke())
        }
    }
}