package com.vwmattr.kotlinweatherapp.dagger.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Dagger module providing top level dependencies for AppComponent.
 */
@Module
class AppModule
    constructor(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application
    }

}