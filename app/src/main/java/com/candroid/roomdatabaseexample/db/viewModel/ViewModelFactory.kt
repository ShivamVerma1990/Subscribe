package com.candroid.roomdatabaseexample.db.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.candroid.roomdatabaseexample.Repository

class ViewModelFactory(val rep: Repository):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelSub(rep) as T
    }
}