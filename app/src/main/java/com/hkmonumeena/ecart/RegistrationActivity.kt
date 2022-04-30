package com.hkmonumeena.ecart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hkmonumeena.ecart.databinding.ActivityRegistrationBinding
import com.hkmonumeena.ecart.helper.Craft
import com.hkmonumeena.ecart.helper.Craft.putKey
import com.hkmonumeena.ecart.helper.Craft.putKeyString
import com.hkmonumeena.ecart.helper.Craft.startActivity
import com.hkmonumeena.ecart.helper.Keys

class RegistrationActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding:ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.materialButtonRegister.setOnClickListener(this)

    }
    private fun getValidatedFields(): Boolean {
        return Craft.isValidate(binding.etFirstName)
            .isValidate(binding.etLastName)
            .isValidate(binding.etMobileNumber)
            .isValidate(binding.etPassword)
            .getValidatedFields()
    }

    private fun insertDataToSharedPref(){
        putKeyString(Keys.FIRST_NAME,binding.etFirstName.text.toString())
        putKeyString(Keys.LAST_NAME,binding.etLastName.text.toString())
        putKeyString(Keys.MOBILE,binding.etMobileNumber.text.toString())
        putKeyString(Keys.PASSWORD,binding.etPassword.text.toString())
        startActivity<LoginActivity>()
        finishAffinity()
    }

    override fun onClick(p0: View?) {
        when(p0){
            binding.materialButtonRegister ->{
                if (getValidatedFields()){
                    insertDataToSharedPref()
                }
            }
        }
    }
}