package com.richardson.githubbest.ui.main

import com.richardson.githubbest.models.GitHubRepo

interface IMainContract {
    interface View {
        fun updateData(repos: Array<GitHubRepo>)
        fun showNoResultsFound()
        fun showError()
        fun showLoading()
        fun hideLoading()

    }

    interface Presenter {
        fun getReposByCompany(query: String)
    }
}