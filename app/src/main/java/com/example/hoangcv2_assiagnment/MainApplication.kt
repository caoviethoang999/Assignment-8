package com.example.hoangcv2_assiagnment

import com.example.hoangcv2_assiagnment.di.component.ApplicationComponent
import com.example.hoangcv2_assiagnment.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MainApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        val component: ApplicationComponent =
            DaggerApplicationComponent.builder().application(this).build()
        component.inject(this)

        return component
    }
}