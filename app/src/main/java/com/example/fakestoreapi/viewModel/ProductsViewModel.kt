package com.example.fakestoreapi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fakestoreapi.model.ModelProducts
import com.example.fakestoreapi.model.repositoriy.Repository

class ProductsViewModel(
    val repository: Repository = Repository()
):ViewModel() {

    fun newAllProducts():MutableLiveData<ArrayList<ModelProducts>>{
        return repository.allProducts()
    }
    fun newAllCategori():MutableLiveData<ArrayList<String>>{
        return repository.allCategories()
    }
    fun newproductsSort(nameCategori:String):MutableLiveData<ArrayList<ModelProducts>>{
        return repository.productSort(nameCategori)
    }
}