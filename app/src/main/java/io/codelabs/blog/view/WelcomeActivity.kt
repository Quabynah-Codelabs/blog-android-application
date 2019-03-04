package io.codelabs.blog.view

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.databinding.DataBindingUtil
import io.codelabs.blog.R
import io.codelabs.blog.core.BlogRootActivity
import io.codelabs.blog.databinding.ActivityWelcomeBinding
import io.codelabs.blog.util.color
import io.codelabs.blog.util.intentTo
import io.github.tonnyl.whatsnew.item.item
import io.github.tonnyl.whatsnew.item.whatsNew
import io.github.tonnyl.whatsnew.util.PresentationOption

class WelcomeActivity : BlogRootActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome)

        // Init database instance
        binding.database = database

        if (binding.database!!.isLoggedIn) {
            Handler().postDelayed({
                intentTo(HomeActivity::class.java, true)
            }, 2000)

        } else {
            val whatsnew = whatsNew {
                item {
                    title = "Nice Icons"
                    content = "Completely customize colors, texts and icons."
                    imageRes = R.drawable.ic_heart
                }
                item {
                    title = "Such Easy"
                    content = "Setting this up only takes 2 lines of code, impressive you say?"
                    imageRes = R.drawable.ic_thumb_up
                }

                buttonTextColor = color(R.color.white)
                presentationOption = PresentationOption.ALWAYS
            }
            whatsnew.presentAutomatically(this)
        }
    }

    fun startApp(v: View?) = intentTo(AuthActivity::class.java, true)
}