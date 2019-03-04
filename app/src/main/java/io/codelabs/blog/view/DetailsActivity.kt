package io.codelabs.blog.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import io.codelabs.blog.R
import io.codelabs.blog.core.BlogRootActivity
import io.codelabs.blog.databinding.ActivityDetailsBinding
import io.codelabs.blog.util.intentTo

class DetailsActivity : BlogRootActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)

        setSupportActionBar(binding.bottomAppBar)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_details_bottom_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_star -> {

            }
            R.id.menu_archive -> {

            }
            R.id.menu_drafts -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        intentTo(HomeActivity::class.java,true)
    }

}