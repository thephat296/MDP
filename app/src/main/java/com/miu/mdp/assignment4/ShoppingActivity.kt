package com.miu.mdp.assignment4

import android.content.Intent.EXTRA_USER
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.R
import com.miu.mdp.databinding.ActivityShoppingBinding

class ShoppingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShoppingBinding
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        user = intent?.getSerializableExtra(EXTRA_USER) as User
        binding.tvWelcome.text = getString(R.string.shopping_welcome_user, user.userName)
        binding.imgBooks.setOnClickListener {
            val category = getString(R.string.shopping_category_books)
            val text = getString(R.string.shopping_category_chosen, category)
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
        binding.imgClothing.setOnClickListener {
            val category = getString(R.string.shopping_category_clothing)
            val text = getString(R.string.shopping_category_chosen, category)
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
        binding.imgFoods.setOnClickListener {
            val category = getString(R.string.shopping_category_organic_foods)
            val text = getString(R.string.shopping_category_chosen, category)
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
        binding.imgMedicines.setOnClickListener {
            val category = getString(R.string.shopping_category_medicines)
            val text = getString(R.string.shopping_category_chosen, category)
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}