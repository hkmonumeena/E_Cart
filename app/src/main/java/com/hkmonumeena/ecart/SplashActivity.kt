package com.hkmonumeena.ecart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.hkmonumeena.ecart.helper.Craft.getKeyBoolean
import com.hkmonumeena.ecart.helper.Craft.startActivity
import com.hkmonumeena.ecart.helper.Keys

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
           newIntent()
        }, 1000)
    }

    private fun newIntent(){
        if (getKeyBoolean(Keys.IS_LOGIN) == true){
            startActivity<HomeActivity>()
        }else{
            startActivity<SelectTypeActivity>()
        }
        finish()
    }
}