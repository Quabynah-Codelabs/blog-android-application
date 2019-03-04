package io.codelabs.blog.model

import android.os.Parcelable

interface SearchableItem : Parcelable {

    val key: String

    var name: String

}