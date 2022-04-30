package com.hkmonumeena.ecart.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.hkmonumeena.ecart.R
import com.hkmonumeena.ecart.adapters.RvAllProducts
import com.hkmonumeena.ecart.adapters.RvShowProducts
import com.hkmonumeena.ecart.databinding.FragmentAllProductsBinding
import com.hkmonumeena.ecart.helper.AppDatabase
import com.hkmonumeena.ecart.helper.BaseFragmentMedusa
import com.hkmonumeena.ecart.models.Product


class AllProductsFragment(val viewTyp: String) : BaseFragmentMedusa() {
    lateinit var binding:FragmentAllProductsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllProductsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageViewBack.setOnClickListener { requireActivity().onBackPressed() }
        getAllProductsFromDb()
    }

    private fun getAllProductsFromDb(){
        AppDatabase.getAppDatabase(requireActivity())?.daoProducts()?.getAllProducts()?.observe(viewLifecycleOwner){
            binding.recyclerViewAllProducts.apply {
                layoutManager = GridLayoutManager(requireActivity(),3)
                adapter = RvAllProducts(it as ArrayList<Product>,this@AllProductsFragment)
            }
        }
    }

}