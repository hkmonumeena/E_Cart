package com.hkmonumeena.ecart.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hkmonumeena.ecart.R
import com.hkmonumeena.ecart.SelectTypeActivity
import com.hkmonumeena.ecart.databinding.FragmentProfileBinding
import com.hkmonumeena.ecart.helper.AppDatabase
import com.hkmonumeena.ecart.helper.BaseFragmentMedusa
import com.hkmonumeena.ecart.helper.Craft
import com.hkmonumeena.ecart.helper.Craft.clearAllKeys
import com.hkmonumeena.ecart.helper.Craft.getKeyString
import com.hkmonumeena.ecart.helper.Craft.startActivity
import com.hkmonumeena.ecart.helper.Keys
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ProfileFragment : BaseFragmentMedusa() {
 lateinit var binding:FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding  = FragmentProfileBinding.inflate(layoutInflater)

        binding.textViewFullName.text = "${requireActivity().getKeyString(Keys.FIRST_NAME)} ${requireActivity().getKeyString(Keys.LAST_NAME)}"
        binding.textViewMobile.text = "${requireActivity().getKeyString(Keys.MOBILE)}"
        binding.materialButtonLogout.setOnClickListener {
            requireActivity().clearAllKeys()
            CoroutineScope(Dispatchers.IO).launch{
                AppDatabase.getAppDatabase(requireActivity())?.clearAllTables()
                requireActivity().startActivity<SelectTypeActivity>()
                requireActivity().finish()
            }

        }
        return binding.root
    }

}