package com.alef.task.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.alef.task.presentation.view.FavouriteFragment
import com.alef.task.presentation.view.FoodListFragment

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val list = listOf(FoodListFragment(), FavouriteFragment())
    private val names = listOf("Food", "Favourite")


    override fun getCount(): Int {
        return list.count()
    }

    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return names[position]
    }


}
