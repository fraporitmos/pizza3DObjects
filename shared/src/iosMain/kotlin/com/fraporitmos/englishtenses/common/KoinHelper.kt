package com.fraporitmos.englishtenses.common

import com.fraporitmos.englishtenses.di.getSharedModules
import org.koin.core.context.startKoin


fun initKoin(){
    startKoin {
        modules(getSharedModules())
    }
}