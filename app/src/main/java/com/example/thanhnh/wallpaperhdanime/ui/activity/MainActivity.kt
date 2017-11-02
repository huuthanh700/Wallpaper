package com.example.thanhnh.wallpaperhdanime.ui.activity

import android.animation.LayoutTransition
import android.app.Dialog
import android.app.ProgressDialog
import android.os.AsyncTask
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import com.example.thanhnh.wallpaperhdanime.R
import com.example.thanhnh.wallpaperhdanime.adapter.CategoryPagerAdapter
import com.example.thanhnh.wallpaperhdanime.data.FirebaseUtil
import com.example.thanhnh.wallpaperhdanime.ui.base.BaseActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {
    var editSearch: EditText? = null
    var searchBar: LinearLayout? = null
    var adapter : CategoryPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        object : AsyncTask<Void, Void, Void>(){
            override fun onPreExecute() {
                super.onPreExecute()
                showDialog("Loading data")
            }
            override fun doInBackground(vararg p0: Void?): Void?{
                FirebaseUtil.getJsonfromFirebase(applicationContext, "naruto_wallpapers.json")
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                dismissDialog()
                adapter?.notifyDataSetChanged()
            }
        }.execute()
    }

    override fun getActivityLayoutId(): Int {
        return R.layout.activity_main
    }

    fun init() {
        adapter = CategoryPagerAdapter(fragmentManager, this)
        viewPager.adapter = adapter
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
