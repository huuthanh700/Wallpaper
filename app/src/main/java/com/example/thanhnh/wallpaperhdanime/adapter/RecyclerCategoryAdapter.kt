package com.example.thanhnh.wallpaperhdanime.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thanhnh.wallpaperhdanime.R
import com.example.thanhnh.wallpaperhdanime.data.model.CategoryAnime
import kotlinx.android.synthetic.main.item_list_category.view.*

/**
 * Created by ThanhNH on 6/23/2017.
 */
class RecyclerCategoryAdapter(var context: Context, var listCategory: ArrayList<CategoryAnime>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return listCategory.size
    }

    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_list_category, p0, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder?, p1: Int) {
        (p0 as ViewHolder).bindData(listCategory[p1])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(categoryAnime: CategoryAnime) { //findViews + add data
            itemView.tvCategoryName.text = categoryAnime.mNameCategory
            itemView.tvToTalImage.text = categoryAnime.mTotalImage.toString() + " "
            if (categoryAnime.id % 2 == 0) {
                itemView.layoutItemCategory.setBackgroundResource(R.drawable.category_nar)
            } else {
                itemView.layoutItemCategory.setBackgroundResource(R.drawable.category_op)
            }
        }
    }
}