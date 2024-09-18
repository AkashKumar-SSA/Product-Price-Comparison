package com.example.productpricecomparison

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.productpricecomparison.databinding.ActivityAddProductBinding
import com.example.productpricecomparison.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddProductBinding
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        databaseReference = FirebaseDatabase.getInstance().getReference("ProductPriceComparison")
        val dataClassObject: ArrayList<ProductData> = ArrayList()
        binding.productRegistrationGoToHomeScreenButton.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

        binding.productRegistrationDataUploadButton.setOnClickListener {
            val productNameRegistration: String = binding.productRegistrationName.text.toString()
            val productShopNameRegistration: String = binding.productRegistrationShopName.text.toString()
            val productShopRatingRegistration: String = binding.productRegistrationShopRating.text.toString()
            val productShopAddressRegistration: String = binding.productRegistrationShopAddress.text.toString()
            val productPriceRegistration: String = binding.productRegistrationProductPrice.text.toString()

            if (productNameRegistration.isEmpty())
                Toast.makeText(this,"Product name can not be Empty",Toast.LENGTH_SHORT).show()
            else if (productShopNameRegistration.isEmpty())
                Toast.makeText(this,"Shop Name field can not be empty",Toast.LENGTH_SHORT).show()
            else if (productShopRatingRegistration.isEmpty())
                Toast.makeText(this,"Shop Rating can not be Empty",Toast.LENGTH_SHORT).show()
            else if (productShopAddressRegistration.isEmpty())
                Toast.makeText(this,"Shop Address can not be Empty",Toast.LENGTH_SHORT).show()
            else if (productPriceRegistration.isEmpty())
                Toast.makeText(this,"Product Price field can not be empty",Toast.LENGTH_SHORT).show()

            if (productNameRegistration.isNotEmpty() &&
                productShopNameRegistration.isNotEmpty() &&
                productShopRatingRegistration.isNotEmpty() &&
                productShopAddressRegistration.isNotEmpty() &&
                productPriceRegistration.isNotEmpty()){
                dataClassObject.add(ProductData(R.drawable.product1,productNameRegistration,productShopNameRegistration,productShopRatingRegistration,productShopAddressRegistration,productPriceRegistration))
                databaseReference.child(dataClassObject[0].productName).setValue(dataClassObject[0])
                    .addOnSuccessListener {
                        Toast.makeText(this,"Product Data uploaded successfully",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,MainActivity::class.java))
                    }
                    .addOnFailureListener{
                        Toast.makeText(this,"Failed to upload data",Toast.LENGTH_SHORT).show()
                    }

            }
        }

    }
}