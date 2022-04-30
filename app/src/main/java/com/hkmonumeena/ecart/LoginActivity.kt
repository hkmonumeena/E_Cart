package com.hkmonumeena.ecart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hkmonumeena.ecart.databinding.ActivityLoginBinding
import com.hkmonumeena.ecart.databinding.ActivityRegistrationBinding
import com.hkmonumeena.ecart.helper.Craft.getKeyString
import com.hkmonumeena.ecart.helper.Craft.isValidate
import com.hkmonumeena.ecart.helper.Craft.putKeyBoolean
import com.hkmonumeena.ecart.helper.Craft.showToast
import com.hkmonumeena.ecart.helper.Craft.startActivity
import com.hkmonumeena.ecart.helper.Keys

class LoginActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.materialButtonLogin.setOnClickListener(this)
    }

    private fun getValidatedFields(): Boolean {
        return isValidate(binding.etMobileNumber)
            .isValidate(binding.etPassword)
            .getValidatedFields()
    }

    private fun loginAction(mobile:String,password:String){
        if (getKeyString(Keys.MOBILE)==mobile && getKeyString(Keys.PASSWORD)==password){
            putKeyBoolean(Keys.IS_LOGIN,true)
            startActivity<HomeActivity>()
            finishAffinity()
        }else{
            showToast("Invalid login credentials")
        }

    }
    override fun onClick(p0: View?) {
        when(p0){
            binding.materialButtonLogin ->{
                if (getValidatedFields()){
                    loginAction(binding.etMobileNumber.text.toString(),binding.etPassword.text.toString())
                }
            }
        }
    }
}