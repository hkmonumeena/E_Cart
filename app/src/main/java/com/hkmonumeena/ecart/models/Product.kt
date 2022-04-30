package com.hkmonumeena.ecart.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "products")
data class Product(
    val productID:Int?,
    val productPrice:Int?,
    val mainCategoryID:Int,
    val productName:String?,
    val productImg:Int?,
    val productDetails:String?,
    @PrimaryKey(autoGenerate = true)
    val id:Long?=null
    )
