package com.example.lab7

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 32, 32, 32)

            val name = intent.getStringExtra("productName") ?: "Unknown"
            val available = intent.getBooleanExtra("isAvailable", false)

            addView(TextView(this@DetailActivity).apply {
                text = "Product: $name"
                textSize = 20f
            })

            addView(TextView(this@DetailActivity).apply {
                text = if (available) "Status: Available" else "Status: Unavailable"
                textSize = 18f
            })
        })
    }
}
