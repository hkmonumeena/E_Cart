package com.hkmonumeena.ecart.helper


import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Gravity
import android.view.WindowManager
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.hkmonumeena.ecart.HomeActivity
import com.hkmonumeena.ecart.R
import com.trendyol.medusalib.navigator.MultipleStackNavigator
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by monu meena date 05 dec 2021
 *
 */
open class BaseFragmentMedusa : Fragment() {
    var multipleStackNavigator: MultipleStackNavigator? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        initStackNavigator(context)
    }

    private fun initStackNavigator(context: Context?) {
        if (context is HomeActivity && multipleStackNavigator == null) {
            multipleStackNavigator = context.multipleStackNavigator
        } else if (context is HomeActivity && multipleStackNavigator == null) {
            multipleStackNavigator = context.multipleStackNavigator
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initStackNavigator(context)
    }

}