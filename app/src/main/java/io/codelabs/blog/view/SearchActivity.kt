package io.codelabs.blog.view

import android.os.Bundle
import io.codelabs.blog.R
import io.codelabs.blog.core.BlogRootActivity
import io.codelabs.sdk.view.BaseActivity

class SearchActivity : BlogRootActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
    }
}
