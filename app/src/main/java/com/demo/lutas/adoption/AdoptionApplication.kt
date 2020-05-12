package com.demo.lutas.adoption

import android.app.Application
import com.demo.lutas.adoption.di.appModule
import com.demo.lutas.adoption.di.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AdoptionApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@AdoptionApplication)
            modules(listOf(remoteModule, appModule))
        }
    }
}