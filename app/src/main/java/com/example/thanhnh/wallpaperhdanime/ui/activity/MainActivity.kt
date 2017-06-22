package com.example.thanhnh.wallpaperhdanime.ui.activity

import android.os.Bundle
import com.example.thanhnh.wallpaperhdanime.R
import com.example.thanhnh.wallpaperhdanime.adapter.CategoryPagerAdapter
import com.example.thanhnh.wallpaperhdanime.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

//    override fun getFragment(): BaseFragment {}

    override fun getActivityLayoutId(): Int {
        return R.layout.activity_main
    }

    fun init() {
        viewPager.adapter = CategoryPagerAdapter(fragmentManager, this)
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.setSelectedTabIndicatorColor(resources.getColor(R.color.indicator_color))
        tabLayout.setTabTextColors(resources.getColor(R.color.white), resources.getColor(R.color.indicator_color))
    }
}
