package io.codelabs.blog.core

import android.app.Application
import io.codelabs.blog.core.koin.databaseModule
import io.codelabs.blog.core.koin.roomModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BlogApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BlogApplication)

            modules(roomModule, databaseModule)
        }
    }
}