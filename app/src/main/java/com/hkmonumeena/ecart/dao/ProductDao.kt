package com.hkmonumeena.ecart.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hkmonumeena.ecart.models.Product

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(modelDb : Product)
    @Update
    fun update (modelDb : Product)

    @Delete
    fun delete(modelDb : Product)


    @Query("SELECT * FROM products")
    fun getAllProducts(): LiveData<List<Product>>

    @Query("SELECT * FROM products WHERE  productID==:productID")
    fun getProductById(productID:Int):Product



}