package io.codelabs.blog.core

import android.app.Application
import io.codelabs.blog.core.koin.*
import io.codelabs.sdk.util.network.DataHandler
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BlogApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        DataHandler.initCache(this)

        startKoin {
            androidContext(this@BlogApplication)

            modules(roomModule, databaseModule,networkModule)
        }
    }
}