package com.example.fakestoreapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fakestoreapi.databinding.ActivityMainBinding
import com.example.fakestoreapi.model.ModelProducts
import com.example.fakestoreapi.retrofit.MAINACTIVITY
import com.example.fakestoreapi.view.adapters.CategoriAdapter
import com.example.fakestoreapi.view.adapters.ProductAdapter
import com.example.fakestoreapi.viewModel.ProductsViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var productsViewModel: ProductsViewModel
    lateinit var categoriAdapter:CategoriAdapter
    lateinit var productAdapter:ProductAdapter

    var arraylistallproducts=ArrayList<ModelProducts>()
    var arraylistallcategories=ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MAINACTIVITY = this

        productsViewModel = ViewModelProvider(this@MainActivity).get(ProductsViewModel::class.java)

        categoriproduct()
        binding.swiperefresh.setOnRefreshListener {
            categoriproduct()
            //binding.swiperefresh.isRefreshing=false
        }


    }

    private fun categoriproduct(){
        binding.apply {
            recyclerCategory.layoutManager = LinearLayoutManager(this@MainActivity,RecyclerView.HORIZONTAL, false)
            productsViewModel.newAllCategori().observe(this@MainActivity,{
                arraylistallcategories = it
                categoriAdapter = CategoriAdapter(this@MainActivity,it)
                recyclerCategory.adapter = categoriAdapter
            })

            recyclerProducts.layoutManager = GridLayoutManager(this@MainActivity,2)
            productsViewModel.newAllProducts().observe(this@MainActivity,{
                arraylistallproducts = it
                productAdapter = ProductAdapter(this@MainActivity,it)
                recyclerProducts.adapter = productAdapter
            })

        }
    }

}