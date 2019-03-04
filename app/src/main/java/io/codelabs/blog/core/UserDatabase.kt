package io.codelabs.blog.core

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import io.codelabs.blog.BuildConfig

/**
 * Local database class for user's token
 */
class UserDatabase private constructor(context: Context) {

    companion object {
        private const val KEY_USER_TOKEN = "KEY_USER_TOKEN"
        private const val KEY_USER_KEY = "KEY_USER_KEY"

        @Volatile
        private var instance: UserDatabase? = null

        @JvmStatic
        fun getInstance(context: Context): UserDatabase {
            return instance ?: synchronized(this) {
                instance ?: UserDatabase(context).also { instance = it }
            }
        }
    }

    private val prefs: SharedPreferences =
        context.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)
    var isLoggedIn = false
    var key: String? = null
        get() = prefs.getString(KEY_USER_KEY, null)
        set(value) {
            field = value
            prefs.edit {
                putString(KEY_USER_KEY, value)
                commit()
            }
        }
    var token: String? = null
        get() = prefs.getString(KEY_USER_TOKEN, null)
        set(value) {
            field = value
            prefs.edit {
                putString(KEY_USER_TOKEN, value)
                commit()
            }
        }

    init {
        key = prefs.getString(KEY_USER_KEY, null)
        token = prefs.getString(KEY_USER_TOKEN, null)

        isLoggedIn = !key.isNullOrEmpty()
        if (isLoggedIn) {
            key = prefs.getString(KEY_USER_TOKEN, null)
            token = prefs.getString(KEY_USER_TOKEN, null)
        }
    }

}