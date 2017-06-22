package com.example.thanhnh.wallpaperhdanime.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.thanhnh.wallpaperhdanime.R

/**
 * Created by ThanhNH on 6/22/2017.
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        if (savedInstanceState == null) addFragment()
        setContentView(getActivityLayoutId())
    }

//    protected abstract fun getFragment(): BaseFragment

    protected abstract fun getActivityLayoutId(): Int

    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount > 0) {
            getCurrentFragment()?.onBackPressed()
        } else {
            super.onBackPressed()
        }
    }

//    fun addFragment() {
//        val transaction = fragmentManager.beginTransaction()
//        transaction.add(R.id.fragment_container, getFragment()).commit()
//    }

    fun replaceFragment(fragment: BaseFragment, tag: String) {
        val transaction = fragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.animator.fragment_slide_right_enter, R.animator.fragment_slide_left_exit
                , R.animator.fragment_slide_left_enter, R.animator.fragment_slide_right_exit)
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(tag).commit()
    }

    fun popFragment() {
        fragmentManager.popBackStack()
    }

    protected fun getCurrentFragment(): BaseFragment? {
        if (fragmentManager.backStackEntryCount > 0) {
            return fragmentManager.findFragmentById(R.id.fragment_container) as BaseFragment
        }
        return null
    }
}