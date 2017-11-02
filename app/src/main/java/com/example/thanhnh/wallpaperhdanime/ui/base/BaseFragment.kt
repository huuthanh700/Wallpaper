package com.example.thanhnh.wallpaperhdanime.ui.base

import android.app.Dialog
import android.os.Bundle
import android.app.Fragment
import android.app.ProgressDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thanhnh.wallpaperhdanime.R


/**
 * Created by ThanhNH on 6/22/2017.
 */
abstract class BaseFragment : Fragment() {
    var progressDialog : Dialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(getFragmentLayoutId(), container, false)
        onCreateContentView(rootView, savedInstanceState)
        return rootView
    }

    protected abstract fun onCreateContentView(rootView: View?, savedInstanceState: Bundle?)

    protected abstract fun getFragmentLayoutId(): Int

    fun onBackPressed() {
        getBaseActivity().popFragment()
    }

    protected fun getBaseActivity(): BaseActivity {
        return activity as BaseActivity
    }

    protected fun getTitle(): String {
        return getString(R.string.app_name)
    }

}

