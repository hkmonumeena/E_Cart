package com.hkmonumeena.ecart.adapters

import android.content.Context
import com.hkmonumeena.ecart.R
import com.hkmonumeena.ecart.helper.AppDatabase
import com.hkmonumeena.ecart.helper.Craft.imageView
import com.hkmonumeena.ecart.helper.Craft.textView
import com.hkmonumeena.ecart.helper.GenericAdapter
import com.hkmonumeena.ecart.helper.ViewHolder
import com.hkmonumeena.ecart.models.ProductsInMyCart
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RvMyCart(items:ArrayList<ProductsInMyCart>,val context:Context):GenericAdapter<ProductsInMyCart>(items) {
    override fun configure(item: ProductsInMyCart, holder: ViewHolder, position: Int) {
        with(holder.itemView){
            textView(R.id.textViewProductTitle).text = item.productName
            textView(R.id.textViewProductPrice).text ="Rs.${item.productPrice}"
            imageView(R.id.imageViewDeleteProd).setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    AppDatabase.getAppDatabase(context)?.daoMyCart()?.delete(item)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.rv_my_cart
    }
}