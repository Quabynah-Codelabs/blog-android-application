package io.codelabs.blog.api

import io.codelabs.blog.model.Blog
import io.codelabs.sdk.util.network.RetrofitLiveData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BlogService {

    companion object {
        const val BASE_URL = "https://us-central1-blog-android-application.cloudfunctions.net/"
    }

    @POST("/blogs/create")
    fun createBlog(@Body blog: Blog): RetrofitLiveData<Void>

    @GET("/blogs")
    fun getAllBlogs(): RetrofitLiveData<MutableList<Blog>>

    @GET("/blogs/{key}")
    fun getBlogByKey(@Path("key") key: String): RetrofitLiveData<Blog>

}