package io.codelabs.blog.view

import android.os.Bundle
import android.view.View
import io.codelabs.blog.R
import io.codelabs.blog.core.BlogRootActivity
import io.codelabs.blog.util.color
import io.codelabs.blog.util.intentTo
import io.github.tonnyl.whatsnew.item.item
import io.github.tonnyl.whatsnew.item.whatsNew
import io.github.tonnyl.whatsnew.util.PresentationOption

class WelcomeActivity : BlogRootActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

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

    fun startApp(v: View?) =
        intentTo(if (!database.isLoggedIn) HomeActivity::class.java else AuthActivity::class.java, true)
}