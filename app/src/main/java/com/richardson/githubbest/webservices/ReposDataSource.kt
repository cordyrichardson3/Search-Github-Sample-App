package com.richardson.githubbest.webservices

import io.reactivex.Observable
import retrofit2.Retrofit

interface IReposDataSource {
    fun fetchRepos(companyQuery: String): Observable<GetReposResponse>
}

class ReposRepository(): IReposDataSource {
    private val remoteReposDataSource = RemoteReposDataSource()
    override fun fetchRepos(companyQuery: String)
            = remoteReposDataSource.fetchRepos(companyQuery)
}

class RemoteReposDataSource(): IReposDataSource {
    override fun fetchRepos(companyQuery: String):Observable<GetReposResponse> {
        val retrofit: Retrofit = GithubRepoService().getRetrofitInstance()
        val queryString = "user:$companyQuery"
        return retrofit.create(IGithubAPI::class.java).getRepos(queryString)
    }
}

