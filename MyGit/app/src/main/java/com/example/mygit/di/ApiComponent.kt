package com.example.mygit.di

import com.example.mygit.model.PullRequestService
import com.example.mygit.viewmodel.PullRequestViewModel
import dagger.Component

@Component(modules=[ApiModel::class])
interface ApiComponent {

    fun inject(service: PullRequestService)

    fun inject(viewModel: PullRequestViewModel)
}