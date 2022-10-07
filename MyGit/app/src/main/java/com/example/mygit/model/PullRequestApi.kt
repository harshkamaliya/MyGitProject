package com.example.mygit.model

import io.reactivex.Single
import retrofit2.http.GET

interface PullRequestApi {
    @GET("repos/Ravindra0310/Grofers/pulls?state=closed")
    fun getPullRequest(): Single<List<PullRequest>>
}
