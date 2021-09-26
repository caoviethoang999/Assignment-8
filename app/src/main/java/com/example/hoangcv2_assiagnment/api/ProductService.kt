package com.example.hoangcv2_assiagnment.api

import com.example.hoangcv2_assiagnment.model.Category
import com.example.hoangcv2_assiagnment.model.Product
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductService {
    @GET("/HoangCV2/displayProduct.php")
    fun getProduct(): Observable<MutableList<Product>>

    @GET("/HoangCV2/displayCategory.php")
    fun getCategory(): Observable<MutableList<Category>>

    @POST("/HoangCV2/displayProductByCategory.php")
    @FormUrlEncoded
    fun getProductByCategory(@Field("category_id") categoryId: Int): Observable<MutableList<Product>>

    @POST("/HoangCV2/deleteProduct.php")
    @FormUrlEncoded
    fun deleteProduct(
        @Field("product_id") productId: Int,
    ): Observable<Product>
}