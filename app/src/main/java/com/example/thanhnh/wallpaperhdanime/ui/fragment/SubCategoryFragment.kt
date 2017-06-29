package com.example.thanhnh.wallpaperhdanime.ui.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.example.thanhnh.wallpaperhdanime.R
import com.example.thanhnh.wallpaperhdanime.adapter.RecyclerUserChoiceAdapter
import com.example.thanhnh.wallpaperhdanime.data.listener.OnRecyclerChoiceItemClickListener
import com.example.thanhnh.wallpaperhdanime.data.model.CategoryAnime
import com.example.thanhnh.wallpaperhdanime.data.model.WallpaperAnime
import com.example.thanhnh.wallpaperhdanime.ui.base.BaseFragment
import com.example.thanhnh.wallpaperhdanime.util.Constants
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.storage.FileDownloadTask
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.fragment_sub_category.*
import java.io.File


class SubCategoryFragment : BaseFragment() {
    var recyclerSubCateAdapter: RecyclerUserChoiceAdapter? = null
    var imageDetailFrag: ImageDetailFragment = ImageDetailFragment()
    var bundle: Bundle? = null
    var categoryAnime: CategoryAnime? = null
    override fun onCreateContentView(rootView: View?, savedInstanceState: Bundle?) {

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun getFragmentLayoutId(): Int {
        return R.layout.fragment_sub_category
    }

    fun init() {
        bundle = arguments
        categoryAnime = bundle?.getSerializable(Constants.CATEGORY_ANIME_KEY) as CategoryAnime
        tvCategoryName.text = categoryAnime?.mNameCategory


        recyclerSubCate.layoutManager = GridLayoutManager(activity, 3) as RecyclerView.LayoutManager?
        recyclerSubCate.setHasFixedSize(true)
        recyclerSubCateAdapter = RecyclerUserChoiceAdapter(activity, getList())
        recyclerSubCate.adapter = recyclerSubCateAdapter
        recyclerSubCateAdapter?.setOnRecyclerItemClick(object : OnRecyclerChoiceItemClickListener {
            override fun onRecyclerItemClick(wallpaperAnime: WallpaperAnime) {
                var bundle: Bundle? = Bundle()
                bundle?.putSerializable(Constants.WALLPAPER_KEY, wallpaperAnime)
                imageDetailFrag.arguments = bundle
                getBaseActivity().replaceFragment(imageDetailFrag, Constants.IMAGE_DETAIL_TAG)
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