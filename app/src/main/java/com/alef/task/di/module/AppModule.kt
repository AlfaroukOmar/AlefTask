package com.alef.task.di.module

import android.app.Application
import android.content.Context
import com.alef.data.source.local.DBContext
import com.alef.data.source.local.DataBaseBuilder
import com.alef.data.source.remote.ApiService
import com.alef.data.source.remote.RetrofitBuilder
import com.alef.task.di.qualifier.IoScheduler
import com.alef.task.di.qualifier.MainScheduler
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton


@Module()
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideDbContext(context: Context): DBContext {
        return DataBaseBuilder.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return RetrofitBuilder.apiService
    }

    @MainScheduler
    @Provides
    @Singleton
    fun provideMainScheduler(): CoroutineDispatcher {
        return Dispatchers.Main
    }

    @IoScheduler
    @Provides
    @Singleton
    fun provideIoScheduler(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}