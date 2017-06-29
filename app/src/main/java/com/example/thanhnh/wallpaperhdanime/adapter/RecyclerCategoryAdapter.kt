package com.example.thanhnh.wallpaperhdanime.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thanhnh.wallpaperhdanime.R
import com.example.thanhnh.wallpaperhdanime.data.listener.OnRecyclerCategoryItemClickListener
import com.example.thanhnh.wallpaperhdanime.data.model.CategoryAnime
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.storage.FileDownloadTask
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.item_list_category.view.*
import java.io.File

/**
 * Created by ThanhNH on 6/23/2017.
 */
class RecyclerCategoryAdapter(var context: Context, var listCategory: List<CategoryAnime>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var onRecyclerCategoryItemClickListener: OnRecyclerCategoryItemClickListener? = null

    fun setOnCategoryItemClickListener(onRecyclerCategoryItemClickListener: OnRecyclerCategoryItemClickListener) {
        this.onRecyclerCategoryItemClickListener = onRecyclerCategoryItemClickListener
    }

    override fun getItemCount(): Int {
        return listCategory!!.size
    }

    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_list_category, p0, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder?, p1: Int) {
        (p0 as ViewHolder)?.bindData(listCategory!![p1], onRecyclerCategoryItemClickListener as OnRecyclerCategoryItemClickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(categoryAnime: CategoryAnime, onRecyclerCategoryItemClickListener: OnRecyclerCategoryItemClickListener) { //findViews + add data
            itemView.tvCategoryName.text = categoryAnime.mNameCategory
            itemView.tvToTalImage.text = categoryAnime.mTotalImage.toString() + " "
            itemView.layoutItemCategory.setBackgroundResource(R.drawable.category_op)
            getJsonfromFirebase()
            itemView.layoutItemCategory.setOnClickListener {
                onRecyclerCategoryItemClickListener.onCategoryItemClick(categoryAnime)
            }
        }
        fun getJsonfromFirebase() {
            val storage = FirebaseStorage.getInstance()
            val storageRef = storage.getReferenceFromUrl("gs://anime-hd-wallpapers-d713f.appspot.com").child("naruto_wallpapers.json")

            val localFile: File = File.createTempFile("anime", "json")
            storageRef.getFile(localFile).addOnSuccessListener {
                object : OnSuccessListener<FileDownloadTask.TaskSnapshot> {
                    override fun onSuccess(p0: FileDownloadTask.TaskSnapshot?) {
                        var test: String = localFile.absolutePath
                        Log.e("test", test)
                    }

                }
            }

        }
    }


}