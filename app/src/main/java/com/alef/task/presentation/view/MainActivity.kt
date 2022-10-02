package com.alef.task.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.alef.task.common.ViewModelFactory
import com.alef.task.presentation.adapter.ViewPagerAdapter
import com.alef.task.databinding.ActivityMainBinding
import com.alef.task.presentation.viewmodel.FoodViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory<FoodViewModel>

    public val foodViewModel: FoodViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(FoodViewModel::class.java)
    }


    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.pager.adapter = ViewPagerAdapter(supportFragmentManager)

        binding.tabLayout.setupWithViewPager(binding.pager);

    }
}