package com.example.mygit.model
import com.google.gson.annotations.SerializedName



data class PullRequest(
    val title:String?,
    @SerializedName("created_at")
    val created_date:String?,
    @SerializedName("closed_at")
    val closed_date:String?,
    val user:User
)
