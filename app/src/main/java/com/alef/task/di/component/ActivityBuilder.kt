package com.alef.task.di.component

import com.alef.task.presentation.view.MainActivity
import com.alef.task.di.module.FoodModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [FoodModule::class])
    abstract fun bindMainActivityActivity(): MainActivity

}