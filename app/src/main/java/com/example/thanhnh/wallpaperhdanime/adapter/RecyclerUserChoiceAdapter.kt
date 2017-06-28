package com.example.thanhnh.wallpaperhdanime.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.thanhnh.wallpaperhdanime.R
import com.example.thanhnh.wallpaperhdanime.data.listener.OnRecyclerChoiceItemClickListener
import com.example.thanhnh.wallpaperhdanime.data.model.WallpaperAnime
import kotlinx.android.synthetic.main.item_list_user_choice.view.*

/**
 * Created by ThanhNH on 6/26/2017.
 */
class RecyclerUserChoiceAdapter(var mContext: Context, var listWallPaper: ArrayList<WallpaperAnime>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var onRecyclerChoiceItemClickListener: OnRecyclerChoiceItemClickListener? = null

    fun setOnRecyclerItemClick(onRecyclerChoiceItemClickListener: OnRecyclerChoiceItemClickListener) {
        this.onRecyclerChoiceItemClickListener = onRecyclerChoiceItemClickListener
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as ViewHolder).bindData(listWallPaper[position], mContext, onRecyclerChoiceItemClickListener as OnRecyclerChoiceItemClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.item_list_user_choice, parent, false)
        return RecyclerUserChoiceAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listWallPaper.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(wallpaperAnime: WallpaperAnime, mContext: Context, onRecyclerChoiceItemClickListener: OnRecyclerChoiceItemClickListener) { //findViews + add data
            itemView.imgWallpaper.setImageResource(R.drawable.item_image)
            itemView.tvTotalView.text = wallpaperAnime.mTotalView.toString()
            Glide.with(mContext).load(wallpaperAnime.urlImage).into(itemView.imgWallpaper)
            itemView.imgWallpaper.setOnClickListener {
                onRecyclerChoiceItemClickListener.onRecyclerItemClick(wallpaperAnime)
            }
        }
    }
}