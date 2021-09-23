package com.example.hoangcv2_assiagnment.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.hoangcv2_assiagnment.model.Category
import com.example.hoangcv2_assiagnment.model.Product

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductViewModel constructor(private val mainRepository: ProductRepository) : ViewModel() {


    var productList=MutableLiveData<MutableList<Product>>()
    var categoryList = MutableLiveData<MutableList<Category>>()
    var errorMessage = MutableLiveData<String>()
    fun getProduct() {
        productList=mainRepository.getProduct()
        errorMessage=mainRepository.handleError()
    }
    fun getCategory(){
        categoryList=mainRepository.getCategory()
        errorMessage=mainRepository.handleError()
    }
    fun getProductByCategory(categoryId: Int) {
        productList = mainRepository.getProductByCategory(categoryId)
        errorMessage=mainRepository.handleError()
    }
}
