package com.example.hoangcv2_assiagnment.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hoangcv2_assiagnment.ViewModelKey
import com.example.hoangcv2_assiagnment.viewmodel.ProductViewModel
import com.example.hoangcv2_assiagnment.viewmodel.ProductViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ProductViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ProductViewModel::class)
    abstract fun bindViewModel(mainViewModel: ProductViewModel): ViewModel

}