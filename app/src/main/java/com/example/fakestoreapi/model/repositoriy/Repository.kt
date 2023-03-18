package com.example.fakestoreapi.model.repositoriy

import androidx.lifecycle.MutableLiveData
import com.example.fakestoreapi.model.ModelProducts
import com.example.fakestoreapi.retrofit.MAINACTIVITY
import com.example.fakestoreapi.retrofit.RetrofitApi.myApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    var arrayAllProducts:ArrayList<ModelProducts> = arrayListOf()


    var arrayProducts = MutableLiveData<ArrayList<ModelProducts>>()
    var arrayAllCategori:ArrayList<String> = arrayListOf()
    var arrayAllCategories = MutableLiveData<ArrayList<String>>()

    fun allProducts():MutableLiveData<ArrayList<ModelProducts>> {
        myApi.getAllProducts().enqueue(object : Callback<ArrayList<ModelProducts>> {
            override fun onResponse(call: Call<ArrayList<ModelProducts>>, response: Response<ArrayList<ModelProducts>>) {
                arrayAllProducts.clear()
                arrayProducts.value = response.body()
                arrayAllProducts.addAll(response.body()!!)
                MAINACTIVITY.binding.swiperefresh.isRefreshing = false
            }
            override fun onFailure(call: Call<ArrayList<ModelProducts>>, t: Throwable) {
            }
        })
        return arrayProducts
    }


    fun allCategories():MutableLiveData<ArrayList<String>>{
        myApi.getAllCategories().enqueue(object : Callback<ArrayList<String>>{
            override fun onResponse(
                call: Call<ArrayList<String>>,
                response: Response<ArrayList<String>>
            ) {
                arrayAllCategori.clear()
                arrayAllCategori.add("All Categori")
                arrayAllCategori.addAll(response.body()!!)
                arrayAllCategories.value = arrayAllCategori
                MAINACTIVITY.binding.swiperefresh.isRefreshing = false
            }

            override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {

            }

        })
        return arrayAllCategories
    }

    var arrayCategoriGroup:ArrayList<ModelProducts> = arrayListOf()

    fun productSort(nameCategory:String):MutableLiveData<ArrayList<ModelProducts>>{
        if (nameCategory == "All Categori"){
            allProducts()
        }else{
            arrayCategoriGroup = arrayAllProducts.filter { it.category == nameCategory } as ArrayList<ModelProducts>
            arrayProducts.value = arrayCategoriGroup
        }
        return arrayProducts
    }
}
