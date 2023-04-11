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
            startActivity(
                ProductListActivity.newIntent(this, generateProducts())
            )
        }
        binding.imgMedicines.setOnClickListener {
            val category = getString(R.string.shopping_category_medicines)
            val text = getString(R.string.shopping_category_chosen, category)
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }

    private fun generateProducts(): List<Product> = listOf(
        Product(
            title = "ORGANIC CALM VATA TEA",
            price = 10.00,
            itemId = "#41231",
            imageRes = R.drawable.ic_calm_vata_tea,
            desc = "Warming, grounding spices balance digestion and settle the mind"
        ),
        Product(
            title = "ORGANIC SOOTHE PITTA TEA",
            price = 8.00,
            itemId = "#12311",
            imageRes = R.drawable.ic_soothe_pitta_tea,
            desc = "Refreshing spices gently cool and uplift"
        ),
        Product(
            title = "ORGANIC ENERGIZE KAPHA® TEA",
            price = 9.00,
            itemId = "#521313",
            imageRes = R.drawable.ic_energize_kapha_tea,
            desc = "Stimulating spices boost your digestion and metabolism"
        ),
        Product(
            title = "WORRY FREE TEA",
            price = 8.50,
            itemId = "#512321",
            imageRes = R.drawable.ic_worry_free_tea,
            desc = "Ashwagandha has many significant benefits, but is best known for its powerful adaptogenic properties, meaning that it helps mind and body adapt better to stress. It nourishes the nerves and improves nerve function to help you maintain calm during stress"
        )
    )
}