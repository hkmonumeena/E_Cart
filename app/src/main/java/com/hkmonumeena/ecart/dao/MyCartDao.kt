package com.hkmonumeena.ecart.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hkmonumeena.ecart.models.Product
import com.hkmonumeena.ecart.models.ProductsInMyCart

@Dao
interface MyCartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(modelDb : ProductsInMyCart)
    @Update
    fun update (modelDb : ProductsInMyCart)

    @Delete
    fun delete(modelDb : ProductsInMyCart)


    @Query("SELECT * FROM my_cart")
    fun getAllProducts(): LiveData<List<ProductsInMyCart>>

    @Query("SELECT * FROM my_cart WHERE  productID==:productID")
    fun getProductById(productID:Int):ProductsInMyCart



}