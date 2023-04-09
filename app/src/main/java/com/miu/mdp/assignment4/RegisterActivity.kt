package com.miu.mdp.assignment4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegister.setOnClickListener {
            registerAccount()
        }
    }

    private fun registerAccount() {
        val firstName = binding.edtFirstName.text.toString()
        val lastName = binding.edtLastName.text.toString()
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.text.toString()
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "All fields must not be empty!", Toast.LENGTH_SHORT).show()
            return
        }
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches().not()) {
            Toast.makeText(this, "Invalid email address!", Toast.LENGTH_SHORT).show()
            return
        }
        // check email exists (out of scope)
        Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()
        val user =
            User(firstName = firstName, lastName = lastName, userName = email, password = password)
        val intent = Intent().putExtra(Intent.EXTRA_USER, user)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}