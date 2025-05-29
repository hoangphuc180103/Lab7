package com.example.lab7

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    private lateinit var rvProducts: RecyclerView
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val products = generateProducts(20)

        rvProducts = findViewById(R.id.rvProducts)
        rvProducts.layoutManager = LinearLayoutManager(this)

        adapter = ProductAdapter(products) { selectedProduct ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("productName", selectedProduct.name)
            intent.putExtra("isAvailable", selectedProduct.isAvailable)
            startActivity(intent)
        }

        rvProducts.adapter = adapter
    }

    private fun generateProducts(count: Int): List<Product> {
        return List(count) { index ->
            Product("Product ${index + 1}", index % 2 == 0)
        }
    }
}
