package com.example.thanhnh.wallpaperhdanime.ui.fragment

import android.app.Dialog
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.thanhnh.wallpaperhdanime.R
import com.example.thanhnh.wallpaperhdanime.data.model.WallpaperAnime
import com.example.thanhnh.wallpaperhdanime.ui.base.BaseFragment
import com.example.thanhnh.wallpaperhdanime.util.Constants.Companion.WALLPAPER_KEY
import com.gjiazhe.panoramaimageview.GyroscopeObserver
import kotlinx.android.synthetic.main.fragment_image_detail.*
import java.io.InputStream
import java.net.URL


/**
 * Created by ThanhNH on 6/26/2017.
 */
class ImageDetailFragment : BaseFragment() {
    var bundle: Bundle? = null
    var wallpaperAnime: WallpaperAnime? = null
    var gyroscopeObserver: GyroscopeObserver? = null

    override fun onCreateContentView(rootView: View?, savedInstanceState: Bundle?) {
    }

    override fun getFragmentLayoutId(): Int {
        return R.layout.fragment_image_detail
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        bundle = arguments
        wallpaperAnime = bundle?.getSerializable(WALLPAPER_KEY) as WallpaperAnime?

        //add panorama imageView
        gyroscopeObserver = GyroscopeObserver()
        gyroscopeObserver?.setMaxRotateRadian(Math.PI/9)
        imgWallpaper.setGyroscopeObserver(gyroscopeObserver)

        Glide.with(this).load(wallpaperAnime?.urlImage).centerCrop().into(imgWallpaper)
        tvImageName.text = wallpaperAnime?.mNameImage
        tvSetWallpaper.setOnClickListener({
            object : AsyncTask<Void, Void, Void>() {
                override fun onPreExecute() {
                    super.onPreExecute()

                }
                override fun doInBackground(vararg voids: Void): Void? {
                    val input: InputStream = URL(wallpaperAnime?.urlImage).openStream()
                    getBaseActivity().setWallpaper(input)
                    /*other way for set homescreen*/
//                    var a: WallpaperManager = WallpaperManager.getInstance(getBaseActivity())
//                        a.setStream(input)
                    return null
                }
            }.execute()
        })
    }
}