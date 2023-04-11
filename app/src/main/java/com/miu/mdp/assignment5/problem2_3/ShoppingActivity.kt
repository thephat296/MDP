package com.miu.mdp.assignment5.problem2_3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.R
import com.miu.mdp.databinding.ActivityShoppingBinding

class ShoppingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShoppingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvFoods.setText(R.string.shopping_category_organic_drinks)
        binding.imgBooks.setOnClickListener {
            startActivity(Intent(this, BookListActivity::class.java))
        }
        binding.imgClothing.setOnClickListener {
            val category = getString(R.string.shopping_category_clothing)
            val text = getString(R.string.shopping_category_chosen, category)
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
        binding.imgFoods.setOnClickListener {
            startActivity(Intent(this, ProductListActivity::class.java))
        }
        binding.imgMedicines.setOnClickListener {
            val category = getString(R.string.shopping_category_medicines)
            val text = getString(R.string.shopping_category_chosen, category)
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}