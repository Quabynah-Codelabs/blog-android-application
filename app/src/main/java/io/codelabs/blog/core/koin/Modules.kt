package io.codelabs.blog.core.koin

import io.codelabs.blog.api.BlogApiService
import io.codelabs.blog.core.BlogApplication
import io.codelabs.blog.core.UserDatabase
import io.codelabs.blog.core.room.BlogAppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/*Room Module DSL*/
val roomModule = module {
    single { BlogAppDatabase.getInstance(androidContext() as BlogApplication).dao() }
}

/*Shared Preferences Module DSL*/
val databaseModule = module {
    single { UserDatabase.getInstance(androidContext() as BlogApplication) }
}

/*Network Module DSL*/
val networkModule = module {
    single { BlogApiService.getInstance().provideService() }
}