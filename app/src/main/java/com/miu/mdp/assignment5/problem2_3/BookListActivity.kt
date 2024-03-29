package com.miu.mdp.assignment5.problem2_3

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.R
import com.miu.mdp.databinding.ActivityBookListBinding

class BookListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val books = resources.getStringArray(R.array.books)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, books)
        binding.lvBooks.adapter = adapter
        binding.lvBooks.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, adapter.getItem(position), Toast.LENGTH_SHORT).show()
        }
    }
}
