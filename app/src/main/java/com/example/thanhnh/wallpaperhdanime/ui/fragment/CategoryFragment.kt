package com.example.thanhnh.wallpaperhdanime.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.thanhnh.wallpaperhdanime.R
import com.example.thanhnh.wallpaperhdanime.adapter.RecyclerCategoryAdapter
import com.example.thanhnh.wallpaperhdanime.data.model.CategoryAnime
import com.example.thanhnh.wallpaperhdanime.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_category.*

/**
 * Created by ThanhNH on 6/22/2017.
 */
class CategoryFragment : BaseFragment() {
    override fun onCreateContentView(rootView: View?, savedInstanceState: Bundle?) {

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun getFragmentLayoutId(): Int {
        return R.layout.fragment_category
    }

    fun init() {
        recyclerCategory.layoutManager = LinearLayoutManager(activity)
        recyclerCategory.setHasFixedSize(true)
        recyclerCategory.adapter = RecyclerCategoryAdapter(activity, getList())
    }

    fun getList(): ArrayList<CategoryAnime> {
        var list = ArrayList<CategoryAnime>()
        list.add(CategoryAnime(1, "Naruto", 360, "url"))
        list.add(CategoryAnime(2, "One Piece", 330, "url"))
        list.add(CategoryAnime(3, "Death Note", 270, "url"))
        list.add(CategoryAnime(4, "One Punch Man", 145, "url"))
        list.add(CategoryAnime(5, "Marvel Comic", 193, "url"))
        return list
    }
}