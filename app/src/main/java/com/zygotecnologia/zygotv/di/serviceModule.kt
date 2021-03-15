package com.zygotecnologia.zygotv.di

import com.zygotecnologia.zygotv.di.servicefactory.OkHttpFactory
import com.zygotecnologia.zygotv.di.servicefactory.OkHttpLoggingFactory
import com.zygotecnologia.zygotv.di.servicefactory.RetrofitFactory
import com.zygotecnologia.zygotv.BuildConfig
import com.zygotecnologia.zygotv.service.remote.ServiceApi
import org.koin.dsl.module

val serviceModule = module(override = true) {
    factory { OkHttpLoggingFactory.provideHttpLoggingInterceptor() }
    factory { OkHttpFactory.providesOkHttpClient(get()) }
    single { RetrofitFactory.createWebService<ServiceApi>(get(), BuildConfig.API_HOST) }

}