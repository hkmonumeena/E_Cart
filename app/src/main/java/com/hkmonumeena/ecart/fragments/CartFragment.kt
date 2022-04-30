package com.hkmonumeena.ecart.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.hkmonumeena.ecart.R
import com.hkmonumeena.ecart.ThankyouActivity
import com.hkmonumeena.ecart.adapters.RvMyCart
import com.hkmonumeena.ecart.databinding.FragmentCartBinding
import com.hkmonumeena.ecart.helper.AppDatabase
import com.hkmonumeena.ecart.helper.BaseFragmentMedusa
import com.hkmonumeena.ecart.helper.Craft.startActivity
import com.hkmonumeena.ecart.models.ProductsInMyCart
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CartFragment : BaseFragmentMedusa() {
  lateinit var binding:FragmentCartBinding
  var listForDeleteCart = arrayListOf<ProductsInMyCart>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMyCartProducts()
        binding.materialButtonCheckOut.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch{
               listForDeleteCart.forEach {
                   AppDatabase.getAppDatabase(requireActivity())?.daoMyCart()?.delete(it)
               }
                requireActivity().startActivity<ThankyouActivity>()
            }
        }
    }

    private fun getMyCartProducts(){
        AppDatabase.getAppDatabase(requireContext())?.daoMyCart()?.getAllProducts()?.observe(viewLifecycleOwner){
            if (!it.isNullOrEmpty()){

                listForDeleteCart = it as ArrayList<ProductsInMyCart>

                binding.recyclerViewMyCart.apply {
                    layoutManager = LinearLayoutManager(requireActivity())
                    adapter = RvMyCart(it,requireContext())
                }
                binding.imageViewEmptyCart.isVisible = false
                binding.textViewEmptyCart.isVisible = false
                binding.recyclerViewMyCart.isVisible = true

            }else{
                binding.imageViewEmptyCart.isVisible = true
                binding.textViewEmptyCart.isVisible = true
                binding.recyclerViewMyCart.isVisible = false
            }
        }
    }

}