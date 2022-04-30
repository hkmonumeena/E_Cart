package com.hkmonumeena.ecart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hkmonumeena.ecart.databinding.ActivitySelectTypeBinding
import com.hkmonumeena.ecart.helper.Craft.startActivity

class SelectTypeActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var binding: ActivitySelectTypeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.materialButtonLogin.setOnClickListener(this)
        binding.materialButtonSignup.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            binding.materialButtonLogin ->{
                startActivity<LoginActivity>()
            }

            binding.materialButtonSignup ->{
                startActivity<RegistrationActivity>()
            }
        }
    }
}