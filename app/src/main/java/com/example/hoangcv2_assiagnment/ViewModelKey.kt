package com.example.hoangcv2_assiagnment

import androidx.lifecycle.ViewModel
import dagger.MapKey
import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target
import kotlin.reflect.KClass


@MapKey
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
annotation class ViewModelKey(val value: KClass<out ViewModel>)
