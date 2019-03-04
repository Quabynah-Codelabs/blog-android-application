package io.codelabs.blog.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * User data model
 */
@Parcelize
@Entity(tableName = "users")
data class User(
    @PrimaryKey override val key: String,
    override var name: String
) : SearchableItem {

    @Ignore
    constructor() : this("", "")

}