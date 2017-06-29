package com.example.thanhnh.wallpaperhdanime.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.thanhnh.wallpaperhdanime.R
import com.example.thanhnh.wallpaperhdanime.adapter.RecyclerCategoryAdapter
import com.example.thanhnh.wallpaperhdanime.data.FirebaseUlti
import com.example.thanhnh.wallpaperhdanime.data.listener.OnRecyclerCategoryItemClickListener
import com.example.thanhnh.wallpaperhdanime.data.model.CategoryAnime
import com.example.thanhnh.wallpaperhdanime.ui.base.BaseFragment
import com.example.thanhnh.wallpaperhdanime.util.Constants
import kotlinx.android.synthetic.main.fragment_category.*

/**
 * Created by ThanhNH on 6/22/2017.
 */
class CategoryFragment : BaseFragment() {
    var recyclerCategoryAdapter: RecyclerCategoryAdapter? = null
    var subCategoryFrag: SubCategoryFragment = SubCategoryFragment()
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
        recyclerCategoryAdapter = RecyclerCategoryAdapter(activity, getList())
        recyclerCategory.adapter = recyclerCategoryAdapter
        recyclerCategoryAdapter?.setOnCategoryItemClickListener(object : OnRecyclerCategoryItemClickListener {
            override fun onCategoryItemClick(categoryAnime: CategoryAnime) {
                var bundle: Bundle? = Bundle()
                bundle?.putSerializable(Constants.CATEGORY_ANIME_KEY, categoryAnime)
                subCategoryFrag.arguments = bundle
                getBaseActivity().replaceFragment(subCategoryFrag, Constants.SUB_CATEGORY_TAG)
            }
        })
    }

    fun getList(): List<CategoryAnime>? {
        return FirebaseUlti.getListCategory()
    }
}