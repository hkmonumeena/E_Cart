package com.hkmonumeena.ecart.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hkmonumeena.ecart.R
import com.hkmonumeena.ecart.adapters.RvMainCategories
import com.hkmonumeena.ecart.adapters.RvShowProducts
import com.hkmonumeena.ecart.adapters.SliderImageAdapter
import com.hkmonumeena.ecart.databinding.FragmentHomeBinding
import com.hkmonumeena.ecart.helper.AppDatabase
import com.hkmonumeena.ecart.helper.BaseFragmentMedusa
import com.hkmonumeena.ecart.models.MainCategories
import com.hkmonumeena.ecart.models.Product


class HomeFragment : BaseFragmentMedusa() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showMainCategories()
        showBanners()
        showProducts()
        initClick()
    }

    private fun initClick(){
        with(binding){
            textViewViewAll.setOnClickListener { multipleStackNavigator?.start(AllProductsFragment("Products")) }
            textViewViewAll2.setOnClickListener { multipleStackNavigator?.start(AllProductsFragment("NewArrival")) }
            textViewViewAll3.setOnClickListener { multipleStackNavigator?.start(AllProductsFragment("FeaturedProducts")) }
        }
    }

    private fun showMainCategories() {
        val listOfMainCategories = arrayListOf<MainCategories>()
        for (i in 0 until 8) {
            listOfMainCategories.add(MainCategories(i, "Jeans"))
        }
        binding.recyclerViewToShowCategories.apply {
            layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.HORIZONTAL,false)
            adapter = RvMainCategories(listOfMainCategories)
        }
    }

    private fun showProducts(){
         AppDatabase.getAppDatabase(requireActivity())?.daoProducts()?.getAllProducts()?.observe(viewLifecycleOwner){
             val topProductsList = ArrayList<Product>()
             for (i in 0 until 5){
                 topProductsList.add(it[i])
             }

             binding.recyclerViewToShowProducts.apply {
                 layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.HORIZONTAL,false)
                 adapter = RvShowProducts(topProductsList,this@HomeFragment)
             }
             binding.recyclerViewNewArrival.apply {
                 layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.HORIZONTAL,false)
                 adapter = RvShowProducts(topProductsList, this@HomeFragment)
             }

             binding.recyclerViewFeatureProduct.apply {
                 layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.HORIZONTAL,false)
                 adapter = RvShowProducts(topProductsList, this@HomeFragment)
             }

         }
    }

    private fun showBanners() {
        val array_image = ArrayList<Int>()
        array_image.add(R.drawable.banner_test)
        array_image.add(R.drawable.ic_cat)
        array_image.add(R.drawable.banner_test)
        array_image.add(R.drawable.ic_cat)

        val adapter = SliderImageAdapter()
        adapter.renewItems(array_image)
        binding.imagViewBanner.setSliderAdapter(adapter)
        binding.imagViewBanner.isAutoCycle = true
        binding.imagViewBanner.startAutoCycle()

    }

}