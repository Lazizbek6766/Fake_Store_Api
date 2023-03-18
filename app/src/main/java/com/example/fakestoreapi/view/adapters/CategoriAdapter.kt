package com.example.fakestoreapi.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.fakestoreapi.databinding.RecyclerCategoryItemBinding
import com.example.fakestoreapi.retrofit.MAINACTIVITY
import com.example.fakestoreapi.viewModel.ProductsViewModel

class CategoriAdapter(
    val context: Context,
    val arrayList: ArrayList<String>
):RecyclerView.Adapter<CategoriAdapter.CategoriViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriViewHolder {
        val view = RecyclerCategoryItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CategoriViewHolder(view)
    }

    override fun getItemCount(): Int =arrayList.size

    override fun onBindViewHolder(holder: CategoriViewHolder, position: Int) {


        holder.binding.apply {
            nameCategori.text = arrayList.get(position)
            btnCategori.setOnClickListener {
                MAINACTIVITY.productsViewModel.newproductsSort(arrayList.get(position))
            }
        }
    }

    class CategoriViewHolder(val binding: RecyclerCategoryItemBinding):RecyclerView.ViewHolder(binding.root)

}