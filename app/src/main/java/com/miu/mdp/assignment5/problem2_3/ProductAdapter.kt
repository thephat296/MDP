package com.miu.mdp.assignment5.problem2_3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miu.mdp.R
import com.miu.mdp.databinding.ItemProductBinding

class ProductAdapter(
    private val products: List<Product>,
    private val onProductClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding).apply {
            this.itemView.setOnClickListener {
                product?.let(onProductClick::invoke)
            }
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.product = product
        with(holder.binding) {
            ivProduct.setImageResource(product.imageRes)
            tvTitle.text = product.title
            tvPrice.text =
                holder.binding.root.context.getString(R.string.product_price, product.price)
        }
    }

    class ViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        var product: Product? = null
    }
}
