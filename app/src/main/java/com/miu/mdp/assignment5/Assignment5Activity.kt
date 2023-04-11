package com.miu.mdp.assignment5

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.R
import com.miu.mdp.assignment5.problem1.QuizActivity
import com.miu.mdp.assignment5.problem2_3.ShoppingActivity

class Assignment5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment_5)
    }

    fun startProblem1(view: View) {
        startActivity(Intent(this, QuizActivity::class.java))
    }

    fun startProblem2And3(view: View) {
        startActivity(Intent(this, ShoppingActivity::class.java))
    }
}