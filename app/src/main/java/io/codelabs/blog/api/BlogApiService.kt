package io.codelabs.blog.api

import com.google.gson.Gson
import io.codelabs.sdk.util.network.DataHandler
import io.codelabs.sdk.util.network.LiveDataCallAdapterFactory
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BlogApiService private constructor() {
    private var blogService: BlogService = Retrofit.Builder()
        .baseUrl(BlogService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .addCallAdapterFactory(LiveDataCallAdapterFactory())
        .client(
            DataHandler.client.newBuilder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)).build()
        ).build().create(BlogService::class.java)

    fun provideService(): BlogService = blogService

    companion object {
        @Volatile
        private var instance: BlogApiService? = null

        @JvmStatic
        fun getInstance(): BlogApiService = instance ?: synchronized(this) {
            instance ?: BlogApiService().also { instance = it }
        }

    }

}