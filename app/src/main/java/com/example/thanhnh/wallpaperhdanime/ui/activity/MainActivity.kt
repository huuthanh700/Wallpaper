package com.example.thanhnh.wallpaperhdanime.ui.activity

import android.animation.LayoutTransition
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import com.example.thanhnh.wallpaperhdanime.R
import com.example.thanhnh.wallpaperhdanime.adapter.CategoryPagerAdapter
import com.example.thanhnh.wallpaperhdanime.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    var editSearch: EditText? = null
    var searchBar: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun getActivityLayoutId(): Int {
        return R.layout.activity_main
    }

    fun init() {
        viewPager.adapter = CategoryPagerAdapter(fragmentManager, this)
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.setSelectedTabIndicatorColor(resources.getColor(R.color.indicator_color))
        tabLayout.setTabTextColors(resources.getColor(R.color.white), resources.getColor(R.color.indicator_color))

        /*change text color searchview*/
        editSearch = searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text)
        editSearch?.setTextColor(resources.getColor(R.color.white))

        /*animate searchbar of searchview*/
        searchBar = searchView.findViewById(android.support.v7.appcompat.R.id.search_bar)
        searchBar?.layoutTransition = LayoutTransition()
    }
}
