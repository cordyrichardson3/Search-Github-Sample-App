package com.richardson.githubbest.webservices

import com.richardson.githubbest.App
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

interface IReposDataSource {
    fun fetchRepos(companyQuery: String): Observable<GetReposResponse>
}

class ReposRepository @Inject constructor(): IReposDataSource {
    private val remoteReposDataSource = RemoteReposDataSource()
    override fun fetchRepos(companyQuery: String)
            = remoteReposDataSource.fetchRepos(companyQuery)
}

class RemoteReposDataSource(): IReposDataSource {
    override fun fetchRepos(companyQuery: String):Observable<GetReposResponse> {
        val retrofit:Retrofit = App().dataAccessComponent.getRetrofitInstance()
        val queryString = "user:$companyQuery"
        return retrofit.create(IGithubAPI::class.java).getRepos(queryString)
    }
}

