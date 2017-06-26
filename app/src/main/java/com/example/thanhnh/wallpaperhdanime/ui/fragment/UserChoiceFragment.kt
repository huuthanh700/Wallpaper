package com.example.thanhnh.wallpaperhdanime.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.example.thanhnh.wallpaperhdanime.R
import com.example.thanhnh.wallpaperhdanime.adapter.RecyclerUserChoiceAdapter
import com.example.thanhnh.wallpaperhdanime.data.listener.OnRecyclerItemClickListener
import com.example.thanhnh.wallpaperhdanime.data.model.WallpaperAnime
import com.example.thanhnh.wallpaperhdanime.ui.activity.ImageDetailActivity
import com.example.thanhnh.wallpaperhdanime.ui.base.BaseFragment
import com.example.thanhnh.wallpaperhdanime.util.Constants.Companion.WALLPAPER_KEY
import kotlinx.android.synthetic.main.fragment_user_choice.*

/**
 * Created by ThanhNH on 6/22/2017.
 */
class UserChoiceFragment : BaseFragment() {
    var recyclerChoiceAdapter: RecyclerUserChoiceAdapter? = null
    var intent: Intent? = null
    override fun onCreateContentView(rootView: View?, savedInstanceState: Bundle?) {

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun getFragmentLayoutId(): Int {
        return R.layout.fragment_user_choice
    }

    private fun init() {
        recyclerChoice.layoutManager = GridLayoutManager(activity, 3)
        recyclerChoice.setHasFixedSize(true)
        recyclerChoiceAdapter = RecyclerUserChoiceAdapter(activity, getList())
        recyclerChoice.adapter = recyclerChoiceAdapter
        recyclerChoiceAdapter?.setOnRecyclerItemClick(object : OnRecyclerItemClickListener {
            override fun onRecyclerItemClick(wallpaperAnime: WallpaperAnime) {
                intent = Intent(activity, ImageDetailActivity::class.java)
                intent?.putExtra(WALLPAPER_KEY, wallpaperAnime)
                startActivity(intent)
            }
        })
    }

    fun getList(): ArrayList<WallpaperAnime> {
        var list = ArrayList<WallpaperAnime>()
        list.add(WallpaperAnime(1, "Naruto", 993, "http://www.hdiphonewallpapers.us/phone-wallpapers/iphone-6s-wallpaper-1-1080x1920/iphone-6s-wallpaper-HD-134hkb1k-1080x1920.jpg"))
        list.add(WallpaperAnime(2, "One Piece", 330, "http://www.hdiphonewallpapers.us/phone-wallpapers/iphone-6s-wallpaper-1-1080x1920/iphone-6s-wallpaper-HD-182683cml-1080x1920.jpg"))
        list.add(WallpaperAnime(3, "Death Note", 270, "http://www.hdiphonewallpapers.us/phone-wallpapers/iphone-6s-wallpaper-1-1080x1920/iphone-6s-wallpaper-HD-164imu7g-1080x1920.jpg"))
        list.add(WallpaperAnime(4, "One Punch Man", 145, "http://www.hdiphonewallpapers.us/phone-wallpapers/iphone-6s-wallpaper-1-1080x1920/iphone-6s-wallpaper-HD-134hkb1k-1080x1920.jpg"))
        list.add(WallpaperAnime(5, "Marvel Comic", 193, "http://www.hdiphonewallpapers.us/phone-wallpapers/iphone-6s-wallpaper-1-1080x1920/iphone-6s-wallpaper-HD-164imu7g-1080x1920.jpg"))
        list.add(WallpaperAnime(6, "Marvel Comic", 123, "http://www.hdiphonewallpapers.us/phone-wallpapers/iphone-6s-wallpaper-1-1080x1920/iphone-6s-wallpaper-HD-182683cml-1080x1920.jpg"))
        list.add(WallpaperAnime(7, "Marvel Comic", 563, "http://www.hdiphonewallpapers.us/phone-wallpapers/iphone-6s-wallpaper-1-1080x1920/iphone-6s-wallpaper-HD-134hkb1k-1080x1920.jpg"))
        list.add(WallpaperAnime(8, "Marvel Comic", 324, "http://www.hdiphonewallpapers.us/phone-wallpapers/iphone-6s-wallpaper-1-1080x1920/iphone-6s-wallpaper-HD-164imu7g-1080x1920.jpg"))
        list.add(WallpaperAnime(9, "Marvel Comic", 214, "http://www.hdiphonewallpapers.us/phone-wallpapers/iphone-6s-wallpaper-1-1080x1920/iphone-6s-wallpaper-HD-134hkb1k-1080x1920.jpg"))
        list.add(WallpaperAnime(10, "Marvel Comic", 634, "http://www.hdiphonewallpapers.us/phone-wallpapers/iphone-6s-wallpaper-1-1080x1920/iphone-6s-wallpaper-HD-182683cml-1080x1920.jpg"))
        list.add(WallpaperAnime(11, "Marvel Comic", 573, "http://www.hdiphonewallpapers.us/phone-wallpapers/iphone-6s-wallpaper-1-1080x1920/iphone-6s-wallpaper-HD-164imu7g-1080x1920.jpg"))
        return list
    }
}