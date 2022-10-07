package com.example.mygit.di

import com.example.mygit.model.PullRequestApi
import com.example.mygit.model.PullRequestService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
class ApiModel {
    private val BASE_URL = "https://api.github.com/"


    @Provides
    fun provideCountriesApi(): PullRequestApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PullRequestApi::class.java)
    }
    @Provides
    fun provideCountriesService(): PullRequestService {
        return PullRequestService()
    }
}