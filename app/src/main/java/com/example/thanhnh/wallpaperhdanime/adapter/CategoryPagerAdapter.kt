package com.example.thanhnh.wallpaperhdanime.adapter

import android.content.Context
import com.example.thanhnh.wallpaperhdanime.R
import com.example.thanhnh.wallpaperhdanime.ui.fragment.CategoryFragment
import com.example.thanhnh.wallpaperhdanime.ui.fragment.UserChoiceFragment

/**
 * Created by ThanhNH on 6/22/2017.
 */
class CategoryPagerAdapter(fm: android.app.FragmentManager, mContext: Context) : android.support.v13.app.FragmentPagerAdapter(fm) {
    private val mContext: Context? = mContext

    override fun getItem(p0: Int): android.app.Fragment? {
        var fragment: android.app.Fragment? = null
        when (p0) {
            0 -> fragment = CategoryFragment()
            1 -> fragment = UserChoiceFragment()
        }
        return fragment
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        var title = ""
        when (position) {
            0 -> title = mContext?.getResources()?.getString(R.string.category_title) as String
            1 -> title = mContext?.getResources()?.getString(R.string.user_title) as String
            2 -> title = mContext?.getResources()?.getString(R.string.download_title) as String
        }
        return title
    }
}