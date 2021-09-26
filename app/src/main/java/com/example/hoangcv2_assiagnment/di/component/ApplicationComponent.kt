package com.example.hoangcv2_assiagnment.di.component

import android.app.Application
import com.example.hoangcv2_assiagnment.MainApplication
import com.example.hoangcv2_assiagnment.di.module.ActivityBuildersModule
import com.example.hoangcv2_assiagnment.di.module.FragmentBuildersModule
import com.example.hoangcv2_assiagnment.di.module.NetworkModule
import com.example.hoangcv2_assiagnment.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ActivityBuildersModule::class,
        FragmentBuildersModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        AndroidSupportInjectionModule::class]
)
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: MainApplication)
}