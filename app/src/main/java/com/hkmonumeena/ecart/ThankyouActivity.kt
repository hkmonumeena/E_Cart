package com.hkmonumeena.ecart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ThankyouActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thankyou)
        val back = findViewById<ImageView>(R.id.imageViewBack)
        back.setOnClickListener {
            finish()
        }
    }
}