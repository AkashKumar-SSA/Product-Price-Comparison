package com.example.productpricecomparison

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyProductDataAdapter(private val productDataList: ArrayList<ProductData>):
    RecyclerView.Adapter<MyProductDataAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val productImage: ImageButton = itemView.findViewById(R.id.productImageButton)
        val productName: TextView = itemView.findViewById(R.id.productName)
        val productShopName: TextView = itemView.findViewById(R.id.productShopName)
        val productShopRating: TextView = itemView.findViewById(R.id.productShopRating)
        val productShopAddress: TextView = itemView.findViewById(R.id.productShopAddress)
        val productPrice: TextView = itemView.findViewById(R.id.productPrice)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_product_cell,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productDataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val dataPointer = productDataList[position]
        holder.productImage.setImageResource(dataPointer.image)
        holder.productName.text = dataPointer.productName
        holder.productShopName.text = dataPointer.shopName
        holder.productShopRating.text = dataPointer.shopRating
        holder.productShopAddress.text = dataPointer.shopAddress
        holder.productPrice.text = dataPointer.productPrice
    }
}