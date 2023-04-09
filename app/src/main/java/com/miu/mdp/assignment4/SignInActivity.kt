package com.miu.mdp.assignment4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private val users = mutableListOf(
        User(firstName = "phat", lastName = "voong", userName = "phat@miu.edu", password = "11111"),
        User(firstName = "leo", lastName = "ken", userName = "leo@miu.edu", password = "22222"),
        User(firstName = "andy", lastName = "kim", userName = "anduy@miu.edu", password = "33333"),
        User(firstName = "ada", lastName = "wong", userName = "ada@miu.edu", password = "44444"),
        User(firstName = "john", lastName = "wick", userName = "john@miu.edu", password = "55555"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSignIn.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()
            users.find { it.userName == email && it.password == password }
                ?.let {
                    val intent = Intent(this, ShoppingActivity::class.java)
                        .putExtra(Intent.EXTRA_USER, it)
                    startActivity(intent)
                }
                ?: Toast.makeText(this, "Email or password incorrect!", Toast.LENGTH_SHORT).show()
        }

        val launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    (result.data?.getSerializableExtra(Intent.EXTRA_USER) as? User)?.let(users::add)
                }
            }
        binding.tvRegister.setOnClickListener {
            launcher.launch(Intent(this, RegisterActivity::class.java))
        }
        binding.tvForgotPassword.setOnClickListener {
            val user = users.firstOrNull() ?: return@setOnClickListener
            val intent = Intent(Intent.ACTION_SEND)
                .setType("text/plain")
                .putExtra(Intent.EXTRA_EMAIL, arrayOf(user.userName))
                .putExtra(Intent.EXTRA_SUBJECT, "Forgot password")
                .putExtra(Intent.EXTRA_TEXT, "Your password is: ${user.password}")
            startActivity(Intent.createChooser(intent, "Send Email"))
        }
    }
}
