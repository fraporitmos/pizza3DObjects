package com.fraporitmos.englishtenses.android

import android.app.Application
import com.fraporitmos.englishtenses.android.di.appModule
import com.fraporitmos.englishtenses.di.getSharedModules
import org.koin.core.context.startKoin

class PizzaInit: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}