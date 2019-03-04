package io.codelabs.blog.core.room

import androidx.lifecycle.LiveData
import androidx.room.*
import io.codelabs.blog.model.User

@Dao
interface BlogAppDao {

    @Insert
    fun createUser(vararg user: User)

    @Query("SELECT * FROM users WHERE `key` = :key")
    fun getCurrentUser(key: String): LiveData<User>

    @Update
    fun updateUser(vararg user: User)

    @Delete
    fun deleteUser(vararg user: User)

}