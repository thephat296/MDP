package com.miu.mdp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.assignment2.Assignment2Activity
import com.miu.mdp.assignment3.Assignment3Activity
import com.miu.mdp.assignment4.SignInActivity
import com.miu.mdp.assignment5.problem1.QuizActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startAssignment2(view: View) {
        startActivity(Intent(this, Assignment2Activity::class.java))
    }

    fun startAssignment3(view: View) {
        startActivity(Intent(this, Assignment3Activity::class.java))
    }

    fun startAssignment4(view: View) {
        startActivity(Intent(this, SignInActivity::class.java))
    }

    fun startAssignment5(view: View) {
        startActivity(Intent(this, QuizActivity::class.java))
    }
}