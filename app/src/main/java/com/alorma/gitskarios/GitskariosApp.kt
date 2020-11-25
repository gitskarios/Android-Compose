package com.alorma.gitskarios

import android.app.Application
import com.alorma.gitskarios.di.NetworkModule
import com.alorma.gitskarios.di.UseCaseModule
import com.alorma.gitskarios.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class GitskariosApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.ERROR)
            androidContext(this@GitskariosApp)
            modules(
                NetworkModule(),
                UseCaseModule(),
                ViewModelModule()
            )
        }
    }

}