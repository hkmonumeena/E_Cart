package com.hkmonumeena.ecart.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "my_cart")
data class ProductsInMyCart(
    val productID:Int?,
    val productPrice:Int?,
    val mainCategoryID:Int,
    val productName:String?,
    val productImg:Int?,
    val productDetails:String?,
    @PrimaryKey(autoGenerate = false)
    val id:Long?=null
    )
