package io.codelabs.blog.core.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.codelabs.blog.BuildConfig
import io.codelabs.blog.model.User

@Database(entities = [User::class], version = BuildConfig.VERSION_CODE, exportSchema = false)
abstract class BlogAppDatabase : RoomDatabase() {

    abstract fun dao(): BlogAppDao

    companion object {
        @Volatile
        private var instance: BlogAppDatabase? = null

        @JvmStatic
        fun getInstance(context: Context): BlogAppDatabase = instance ?: synchronized(this) {
            instance ?: Room.databaseBuilder(context, BlogAppDatabase::class.java, "${BuildConfig.APPLICATION_ID}_db")
                .fallbackToDestructiveMigration()
                .build().also { instance = it }
        }
    }

}