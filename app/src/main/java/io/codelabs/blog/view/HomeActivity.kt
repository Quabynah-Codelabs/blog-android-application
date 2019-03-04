package io.codelabs.blog.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import io.codelabs.blog.R
import io.codelabs.blog.core.BlogRootActivity
import io.codelabs.blog.databinding.ActivityHomeBinding
import io.codelabs.blog.util.intentTo

class HomeActivity : BlogRootActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        setSupportActionBar(binding.bottomAppBar)

        binding.fab.setOnClickListener { intentTo(CreateBlogActivity::class.java) }
    }

    override fun onPause() {
        overridePendingTransition(R.anim.post_story_enter, R.anim.post_story_exit)
        super.onPause()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home_bottom_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_search -> {
                intentTo(SearchActivity::class.java)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}