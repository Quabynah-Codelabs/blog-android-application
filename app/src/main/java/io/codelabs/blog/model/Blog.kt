package io.codelabs.blog.model

import kotlinx.android.parcel.Parcelize

@Parcelize
data class Blog(override val key: String, override var name: String) : SearchableItem {


    constructor() : this("", "")
}