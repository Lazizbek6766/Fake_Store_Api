package com.example.fakestoreapi.retrofit

import com.example.fakestoreapi.model.ModelProducts
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("products")
    fun getAllProducts():Call<ArrayList<ModelProducts>>

    @GET("products/categories")
    fun getAllCategories():Call<ArrayList<String>>

}
