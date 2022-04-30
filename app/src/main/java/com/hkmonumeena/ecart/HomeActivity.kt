package com.hkmonumeena.ecart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hkmonumeena.ecart.adapters.RvMainCategories
import com.hkmonumeena.ecart.adapters.SliderImageAdapter
import com.hkmonumeena.ecart.databinding.ActivityHomeBinding
import com.hkmonumeena.ecart.fragments.CartFragment
import com.hkmonumeena.ecart.fragments.CategoriesFragment
import com.hkmonumeena.ecart.fragments.HomeFragment
import com.hkmonumeena.ecart.fragments.ProfileFragment
import com.hkmonumeena.ecart.helper.AppDatabase
import com.hkmonumeena.ecart.helper.Craft.getKeyBoolean
import com.hkmonumeena.ecart.helper.Craft.putKeyBoolean
import com.hkmonumeena.ecart.helper.Keys
import com.hkmonumeena.ecart.models.MainCategories
import com.hkmonumeena.ecart.models.Product
import com.smarteist.autoimageslider.SliderView
import com.trendyol.medusalib.navigator.MultipleStackNavigator
import com.trendyol.medusalib.navigator.Navigator
import com.trendyol.medusalib.navigator.NavigatorConfiguration
import com.trendyol.medusalib.navigator.transaction.NavigatorTransaction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity(), Navigator.NavigatorListener {
    lateinit var binding: ActivityHomeBinding
    private val rootsFragmentProvider: List<Function0<Fragment>> =
        listOf({ HomeFragment() },{ CategoriesFragment() },{ CartFragment() },{ ProfileFragment() })

    val multipleStackNavigator: MultipleStackNavigator =
        MultipleStackNavigator(
            supportFragmentManager,
            R.id.nav_host_fragment_activity_main2,
            rootsFragmentProvider,
            navigatorListener = this,
            navigatorConfiguration = NavigatorConfiguration(0, true, NavigatorTransaction.SHOW_HIDE)
        )

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_1 -> {
                    multipleStackNavigator.switchTab(0)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.page_2 -> {
                    multipleStackNavigator.switchTab(1)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.page_3 -> {
                    multipleStackNavigator.switchTab(2)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.page_4 -> {
                    multipleStackNavigator.switchTab(3)
                    return@OnNavigationItemSelectedListener true
                }

            }
            false
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (getKeyBoolean(Keys.IS_PRODUCT_INSERTED) == false){
            insertProductsInToDb()
        }

        multipleStackNavigator.initialize(savedInstanceState)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


    }

    private fun insertProductsInToDb() {
        val listOfProducts = arrayListOf<Product>()
        val product1 = Product(
            1,
            5000,
            1,
            "Dell Optiplex",
            R.drawable.ic_cat,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged."
        )
        val product2 = Product(
            2,
            6000,
            1,
            "Hp Monitor",
            R.drawable.ic_cat,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged."
        )
        val product3 = Product(
            3,
            9000,
            1,
            "Hp 152C",
            R.drawable.ic_cat,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged."
        )
        val product4 = Product(
            4,
            7500,
            1,
            "Acer 152D",
            R.drawable.ic_cat,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged."
        )
        val product5 = Product(
            5,
            8500,
            1,
            "Acer 1992",
            R.drawable.ic_cat,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged."
        )
        val product6 = Product(
            6,
            9600,
            1,
            "Acer Lux Dc",
            R.drawable.ic_cat,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged."
        )
        val product7 = Product(
            7,
            7845,
            1,
            "Lapcare 512D",
            R.drawable.ic_cat,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged."
        )
        val product8 = Product(
            8,
            2541,
            1,
            "Hitachi Monitor",
            R.drawable.ic_cat,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged."
        )
        val product9 = Product(
            9,
            1245,
            1,
            "LG 1110D",
            R.drawable.ic_cat,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged."
        )
        val product10 = Product(
            10,
            5622,
            1,
            "Videocon 15s",
            R.drawable.ic_cat,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged."
        )

        listOfProducts.add(product1)
        listOfProducts.add(product2)
        listOfProducts.add(product3)
        listOfProducts.add(product4)
        listOfProducts.add(product5)
        listOfProducts.add(product6)
        listOfProducts.add(product7)
        listOfProducts.add(product8)
        listOfProducts.add(product9)
        listOfProducts.add(product10)

        CoroutineScope(Dispatchers.IO).launch {
            listOfProducts.forEach { product ->
                AppDatabase.getAppDatabase(this@HomeActivity)?.daoProducts()?.insert(product)
            }
        }

        putKeyBoolean(Keys.IS_PRODUCT_INSERTED,true)

    }

    override fun onBackPressed() {
        if (multipleStackNavigator.canGoBack()){
            multipleStackNavigator.goBack()
        }else{
            super.onBackPressed()
        }

    }


    override fun onTabChanged(tabIndex: Int) {
        when (tabIndex) {
            0 -> binding.bottomNavigationView.selectedItemId = R.id.page_1
            1 -> binding.bottomNavigationView.selectedItemId = R.id.page_2
            2 -> binding.bottomNavigationView.selectedItemId = R.id.page_3
            3 -> binding.bottomNavigationView.selectedItemId = R.id.page_4
        }
    }
}