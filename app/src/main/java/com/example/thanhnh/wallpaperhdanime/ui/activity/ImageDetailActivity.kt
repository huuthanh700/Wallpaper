package com.example.thanhnh.wallpaperhdanime.ui.activity

import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.thanhnh.wallpaperhdanime.R
import com.example.thanhnh.wallpaperhdanime.data.model.WallpaperAnime
import com.example.thanhnh.wallpaperhdanime.ui.base.BaseActivity
import com.example.thanhnh.wallpaperhdanime.util.Constants.Companion.WALLPAPER_KEY
import kotlinx.android.synthetic.main.activity_image_detail.*

/**
 * Created by ThanhNH on 6/26/2017.
 */
class ImageDetailActivity : BaseActivity() {
    var wallpaperAnime: WallpaperAnime? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun getActivityLayoutId(): Int {
        return R.layout.activity_image_detail
    }

    private fun init() {
        wallpaperAnime = intent.getSerializableExtra(WALLPAPER_KEY) as WallpaperAnime?
        Glide.with(this).load(wallpaperAnime?.urlImage).centerCrop().into(imgWallpaper)

        tvImageName.text = wallpaperAnime?.mNameImage
    }
}