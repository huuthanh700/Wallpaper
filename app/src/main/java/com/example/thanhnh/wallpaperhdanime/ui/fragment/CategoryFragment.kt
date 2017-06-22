package com.example.thanhnh.wallpaperhdanime.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.thanhnh.wallpaperhdanime.R
import com.example.thanhnh.wallpaperhdanime.ui.base.BaseFragment

/**
 * Created by ThanhNH on 6/22/2017.
 */
class CategoryFragment : BaseFragment() {
    override fun onCreateContentView(rootView: View?, savedInstanceState: Bundle?) {
        findViews()
    }

    override fun getFragmentLayoutId(): Int {
        return R.layout.fragment_category
    }

    fun findViews() {

    }

}