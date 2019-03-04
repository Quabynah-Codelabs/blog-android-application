package io.codelabs.blog.core

import android.app.Application
import com.google.firebase.FirebaseApp
import io.codelabs.blog.core.koin.*
import io.codelabs.sdk.util.debugLog
import io.codelabs.sdk.util.network.DataHandler
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BlogApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val app = FirebaseApp.initializeApp(this)
        debugLog(app?.name)

        DataHandler.initCache(this)

        startKoin {
            androidContext(this@BlogApplication)

            modules(roomModule, databaseModule,networkModule)
        }
    }
}