package com.miu.mdp.assignment5.problem2_3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.R
import com.miu.mdp.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val product = intent.getSerializableExtra(EXTRA_PRODUCT) as Product
        with(binding) {
            ivProduct.setImageResource(product.imageRes)
            tvTitle.text = product.title
            tvPrice.text = getString(R.string.product_price, product.price)
            tvItemId.text = product.itemId
            tvDescription.text = product.desc
        }
    }

    companion object {
        private const val EXTRA_PRODUCT = "EXTRA_PRODUCT"
        fun newIntent(activity: Activity, product: Product): Intent {
            return Intent(activity, ProductDetailActivity::class.java)
                .putExtra(EXTRA_PRODUCT, product)
        }
    }
}