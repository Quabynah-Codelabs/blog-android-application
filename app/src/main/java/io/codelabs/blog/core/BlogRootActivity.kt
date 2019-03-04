package io.codelabs.blog.core

import io.codelabs.blog.core.room.BlogAppDao
import io.codelabs.sdk.view.BaseActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

abstract class BlogRootActivity : BaseActivity() {
    val database: UserDatabase by inject { parametersOf(application as BlogApplication) }
    val dao: BlogAppDao by inject { parametersOf(application as BlogApplication) }
}