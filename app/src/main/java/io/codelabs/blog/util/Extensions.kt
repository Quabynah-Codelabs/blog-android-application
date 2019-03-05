package io.codelabs.blog.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import io.codelabs.blog.R
import io.codelabs.blog.core.BlogRootActivity
import io.codelabs.blog.core.BlogRootFragment

fun Activity.intentTo(target: Class<out Activity>, isFinished: Boolean = false) {
    startActivity(Intent(this, target))
    if (isFinished) finishAfterTransition()
    overridePendingTransition(R.anim.post_story_enter, R.anim.post_story_exit)
}

fun Context.toggleView(enabled: Boolean, vararg views: View) {
    for (v in views) {
        v.isEnabled = enabled
    }
}

fun BlogRootActivity.addFragment(root: Int, fragment: BlogRootFragment) {
    supportFragmentManager.beginTransaction()
        .setReorderingAllowed(true)
        .replace(root, fragment)
        .addToBackStack(null)
        .commit()
}

fun Context.color(@ColorRes color: Int) = ContextCompat.getColor(this, color)