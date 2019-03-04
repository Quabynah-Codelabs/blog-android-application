package io.codelabs.blog.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import io.codelabs.blog.R

fun Activity.intentTo(target: Class<out Activity>, isFinished: Boolean = false) {
    startActivity(Intent(this, target))
    if (isFinished) finishAfterTransition()
    overridePendingTransition(R.anim.post_story_enter, R.anim.post_story_exit)
}

fun Context.color(@ColorRes color: Int) = ContextCompat.getColor(this, color)