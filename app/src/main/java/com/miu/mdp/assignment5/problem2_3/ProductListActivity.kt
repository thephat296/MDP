package com.miu.mdp.assignment5.problem2_3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.miu.mdp.databinding.ActivityProductListBinding

class ProductListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val products = intent.getSerializableExtra(EXTRA_PRODUCT_LIST) as List<Product>
        val productAdapter = ProductAdapter(
            products = products,
            onProductClick = { product ->
                startActivity(ProductDetailActivity.newIntent(this, product))
            }
        )
        binding.rvProduct.layoutManager = LinearLayoutManager(this)
        binding.rvProduct.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
        binding.rvProduct.adapter = productAdapter
    }

    companion object {
        private const val EXTRA_PRODUCT_LIST = "EXTRA_PRODUCT_LIST"
        fun newIntent(activity: Activity, products: List<Product>): Intent {
            return Intent(activity, ProductListActivity::class.java)
                .putExtra(EXTRA_PRODUCT_LIST, products as java.io.Serializable)
        }
    }
}