package com.alef.task.common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

open class BaseViewModel : ViewModel() {

    private var compositeDisposable: Job = Job()

    fun addDisposable(disposable: Job) {
        compositeDisposable = disposable
    }

    override fun onCleared() {
        compositeDisposable.cancel()
        super.onCleared()
    }
}

