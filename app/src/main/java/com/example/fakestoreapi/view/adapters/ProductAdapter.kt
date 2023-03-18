package com.example.fakestoreapi.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fakestoreapi.databinding.RecyclerProductsItemBinding
import com.example.fakestoreapi.model.ModelProducts

class ProductAdapter(
    val context: Context,
    val arraylist: ArrayList<ModelProducts>
):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = RecyclerProductsItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int =arraylist.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.binding.apply {
            Glide.with(context).load(arraylist.get(position).image).into(imageProduct)
            titleProduct.text = arraylist.get(position).title
            rateProduct.text = "${arraylist.get(position).rating.rate} (${arraylist.get(position).rating.count})"
            priceProduct.text = "${arraylist.get(position).price} $"
        }

    }
    class ProductViewHolder(val binding: RecyclerProductsItemBinding):RecyclerView.ViewHolder(binding.root)

}