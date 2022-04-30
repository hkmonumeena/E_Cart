package com.hkmonumeena.ecart.helper


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hkmonumeena.ecart.dao.MyCartDao
import com.hkmonumeena.ecart.dao.ProductDao
import com.hkmonumeena.ecart.models.Product
import com.hkmonumeena.ecart.models.ProductsInMyCart

@Database(entities = [Product::class,ProductsInMyCart::class], version =1 ,exportSchema = false)
abstract class AppDatabase :RoomDatabase(){

    abstract fun daoProducts():ProductDao
    abstract fun daoMyCart(): MyCartDao
    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getAppDatabase(context: Context): AppDatabase? {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "e_cart"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return INSTANCE
            }

        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}