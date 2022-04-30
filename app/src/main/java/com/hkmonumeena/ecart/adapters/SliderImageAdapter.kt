package com.hkmonumeena.ecart.adapters


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.hkmonumeena.ecart.HomeActivity
import com.hkmonumeena.ecart.R
import com.smarteist.autoimageslider.SliderViewAdapter
import com.squareup.picasso.Picasso

class SliderImageAdapter() :
    SliderViewAdapter<SliderImageAdapter.VH>() {
    private var mSliderItems = ArrayList<Int>()

    fun renewItems(sliderItems: ArrayList<Int>) {
        sliderItems.also { it.also { mSliderItems = it } }
        notifyDataSetChanged()
    }

    fun addItem(sliderItem: Int) {
        mSliderItems.add(sliderItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup): VH {
        val inflate: View = LayoutInflater.from(parent.context).inflate(R.layout.slider_image_holder, null)
        return VH(inflate)
    }

    override fun onBindViewHolder(viewHolder: VH, position: Int) {
        Picasso.get().load(mSliderItems[position]).fit().into(viewHolder.imageView)
    }

    override fun getCount(): Int {
        return mSliderItems.size
    }

    inner class VH(itemView: View) : ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.imagViewBanner)

    }
}