package com.example.thanhnh.wallpaperhdanime.ui.activity

import android.animation.LayoutTransition
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import com.example.thanhnh.wallpaperhdanime.R
import com.example.thanhnh.wallpaperhdanime.adapter.CategoryPagerAdapter
import com.example.thanhnh.wallpaperhdanime.data.model.CategoryAnime
import com.example.thanhnh.wallpaperhdanime.ui.base.BaseActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {


    var editSearch: EditText? = null
    var searchBar: LinearLayout? = null

    //Firebase
    var database: FirebaseDatabase? = null
    var databaseRef: DatabaseReference? = null
    var generic: GenericTypeIndicator<List<CategoryAnime>>? = null
    var listCategory: ArrayList<CategoryAnime>? = ArrayList()
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

        /*firebase*/
        database = FirebaseDatabase.getInstance()
        databaseRef = database?.getReference()
        databaseRef?.child("animes")?.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot?) {
                var nodes: Iterator<DataSnapshot> = p0?.children?.iterator()!!
                while (nodes.hasNext()) {
                    var node: DataSnapshot = nodes.next()
                    var categoryAnime: CategoryAnime = CategoryAnime(1, node.child("name").toString(), 1, "content")
                    listCategory?.add(categoryAnime)
                }
                Log.e("list category", listCategory?.size.toString())
            }

            override fun onCancelled(p0: DatabaseError?) {

            }
        })
    }
}
