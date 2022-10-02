package com.alef.task

import android.app.Application
import android.content.Context
import com.alef.task.di.module.AppComponent
import com.alef.task.di.module.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {


    var appComponent: AppComponent? = null

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent?.inject(this)
    }

    companion object {
        @JvmField
        var mContext: Context? = null
        @JvmField
        var dialogwidth = 200
        @JvmField
        var dialogHiegt = 120
    }

}