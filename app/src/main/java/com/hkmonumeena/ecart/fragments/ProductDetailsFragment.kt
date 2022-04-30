package com.hkmonumeena.ecart.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hkmonumeena.ecart.R
import com.hkmonumeena.ecart.databinding.FragmentProductDetailsBinding
import com.hkmonumeena.ecart.helper.AppDatabase
import com.hkmonumeena.ecart.helper.BaseFragmentMedusa
import com.hkmonumeena.ecart.helper.Craft.showToast
import com.hkmonumeena.ecart.models.Product
import com.hkmonumeena.ecart.models.ProductsInMyCart
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ProductDetailsFragment(val item: Product) : BaseFragmentMedusa(), View.OnClickListener {
    lateinit var binding: FragmentProductDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageViewBack.setOnClickListener(this)
        binding.materialButtonAddToCart.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.imageViewBack -> {
                requireActivity().onBackPressed()
            }

            binding.materialButtonAddToCart -> {
                CoroutineScope(Dispatchers.IO).launch {
                    val addToCart = ProductsInMyCart(
                        item.productID,
                        item.productPrice,
                        item.mainCategoryID,
                        item.productName,
                        item.productImg,
                        item.productDetails,
                        item.id)
                    AppDatabase.getAppDatabase(requireActivity())?.daoMyCart()?.insert(addToCart)
                }
                requireActivity().showToast("Product Added In Cart Successfully")
            }
        }
    }

}