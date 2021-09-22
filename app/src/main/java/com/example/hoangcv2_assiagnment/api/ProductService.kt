package com.example.hoangcv2_assiagnment.api

import com.example.hoangcv2_assiagnment.model.Category
import com.example.hoangcv2_assiagnment.model.Product
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.*

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


    companion object {
        var retrofitService: ProductService? = null
        fun getInstance() : ProductService {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("http://192.168.1.10")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
                retrofitService = retrofit.create(ProductService::class.java)
            }
            return retrofitService!!
        }

    }
}