package com.hkmonumeena.ecart.adapters

import com.hkmonumeena.ecart.R
import com.hkmonumeena.ecart.helper.Craft.textView
import com.hkmonumeena.ecart.helper.GenericAdapter
import com.hkmonumeena.ecart.helper.ViewHolder
import com.hkmonumeena.ecart.models.MainCategories

class RvMainCategories(items:ArrayList<MainCategories>):GenericAdapter<MainCategories>(items) {
    override fun configure(item: MainCategories, holder: ViewHolder, position: Int) {
       with(holder.itemView){
           textView(R.id.textViewCloths).text =item.categoryName
       }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.rv_show_categories
    }
}