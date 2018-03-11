package com.pvcresin.slidingtabdemo

import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager = findViewById(R.id.viewPager)
        viewPager.adapter = MyFragmentPagerAdapter(supportFragmentManager)

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
        tabLayout.setupWithViewPager(viewPager)
    }
}


class MyFragment : Fragment() {

    companion object {
        const val BACKGROUND_COLOR = "background_color"

        fun newInstance(@ColorRes IdRes: Int): MyFragment {
            val fragment = MyFragment()
            fragment.arguments = Bundle().also {
                it.putInt(BACKGROUND_COLOR, IdRes)
            }
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_main, null)
        val layout: View = view.findViewById(R.id.fragment_main)
        layout.setBackgroundResource(arguments.getInt(BACKGROUND_COLOR))
        return view
    }
}

class MyFragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return MyFragment.newInstance(android.R.color.holo_blue_bright)
            1 -> return MyFragment.newInstance(android.R.color.holo_green_light)
            2 -> return MyFragment.newInstance(android.R.color.holo_red_dark)
            3 -> return MyFragment.newInstance(android.R.color.holo_blue_bright)
            4 -> return MyFragment.newInstance(android.R.color.holo_green_light)
            5 -> return MyFragment.newInstance(android.R.color.holo_red_dark)
            6 -> return MyFragment.newInstance(android.R.color.holo_blue_bright)
            7 -> return MyFragment.newInstance(android.R.color.holo_green_light)
        }
        return null
    }

    override fun getCount() = 8

    override fun getPageTitle(position: Int) = "Page ${position + 1}"
}