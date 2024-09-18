package com.example.productpricecomparison

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.productpricecomparison.databinding.ActivityProductDetailsBinding

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val productName = intent.getStringExtra("productName")
        binding.productDetailsHeading.text = productName
        val productShopName = intent.getStringExtra("productShopName")
        binding.productShopNameDetails.text = "Shop Name: $productShopName"
        val productShopRating = intent.getStringExtra("productShopRating")
        binding.productShopRatingDetails.text = "Rating: $productShopRating"
        val productShopAddress = intent.getStringExtra("productShopAddress")
        binding.productShopAddressDetails.text = "Address: $productShopAddress"
        val productPrice = intent.getStringExtra("productPrice")
//        productPrice = "Rate: $productPrice"
        binding.productShopPriceDetails.text = "Rate: $productPrice"
        binding.productImageButton.setImageResource(R.drawable.product1)

        binding.productDetailsHeading.setOnClickListener{
            Toast.makeText(this,"You clicked on $productName",Toast.LENGTH_SHORT).show()
        }

    }
}