package io.codelabs.blog.api

import io.codelabs.blog.model.Blog
import io.codelabs.blog.model.User
import io.codelabs.sdk.util.network.RetrofitLiveData
import retrofit2.http.*

interface BlogService {

    companion object {
        const val BASE_URL = "https://us-central1-blog-android-application.cloudfunctions.net/"
    }

    data class TestData(val message: String)

    @POST("/blogs/create")
    fun createBlog(@Body blog: Blog): RetrofitLiveData<Void>

    @GET("/blogs")
    fun getAllBlogs(): RetrofitLiveData<MutableList<Blog>>

    @GET("/blogs/{key}")
    fun getBlogByKey(@Path("key") key: String): RetrofitLiveData<Blog>

    @DELETE("/blogs/{key}")
    fun deleteBlog(@Path("key") key: String): RetrofitLiveData<Void>

    @GET("/api")
    fun getTestData(): RetrofitLiveData<TestData>

    @POST("/users/create")
    fun createUser(@Body user: User): RetrofitLiveData<Void>

    @GET("/users/{key}")
    fun getCurrentUser(@Path("key") key: String): RetrofitLiveData<User>

    @PUT("/users/{key}")
    fun updateUser(@Path("key") key: String, user: User): RetrofitLiveData<User>

}