package com.hkmonumeena.ecart.adapters

import com.hkmonumeena.ecart.R
import com.hkmonumeena.ecart.fragments.HomeFragment
import com.hkmonumeena.ecart.fragments.ProductDetailsFragment
import com.hkmonumeena.ecart.helper.Craft.textView
import com.hkmonumeena.ecart.helper.GenericAdapter
import com.hkmonumeena.ecart.helper.ViewHolder
import com.hkmonumeena.ecart.models.Product

class RvShowProducts(items: ArrayList<Product>, val homeFragment: HomeFragment):GenericAdapter<Product>(items) {
    override fun configure(item: Product, holder: ViewHolder, position: Int) {
        with(holder.itemView){
            textView(R.id.textViewCloths).text = item.productName
            textView(R.id.textViewPrice).text = "Rs.${item.productPrice}"
           setOnClickListener {
               homeFragment.multipleStackNavigator?.start(ProductDetailsFragment(item))
           }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.rv_show_products
    }
}