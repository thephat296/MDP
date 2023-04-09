package com.miu.mdp.assignment5.problem1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.R
import com.miu.mdp.databinding.ActivityQuizBinding
import java.text.SimpleDateFormat
import java.util.*

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun submit(view: View) {
        var result = 0
        if (binding.rbQuestion1Answer1.isChecked) {
            result += POINTS_PER_CORRECT_ANSWER
        }
        if (binding.cbQuestion2Answer1.isChecked && binding.cbQuestion2Answer2.isChecked && binding.cbQuestion2Answer3.isChecked.not()) {
            result += POINTS_PER_CORRECT_ANSWER
        }
        val currentDateAndTime = SimpleDateFormat(DATE_TIME_PATTERN, Locale.getDefault())
            .format(Calendar.getInstance().time)
        val message = getString(R.string.quiz_msg_submitted, currentDateAndTime, "$result%")
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun reset(view: View) {
        with(binding) {
            rgQuestion1Answers.clearCheck()
            cbQuestion2Answer1.isChecked = false
            cbQuestion2Answer2.isChecked = false
            cbQuestion2Answer3.isChecked = false
        }
    }

    companion object {
        private const val POINTS_PER_CORRECT_ANSWER = 50
        private const val DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss"
    }
}