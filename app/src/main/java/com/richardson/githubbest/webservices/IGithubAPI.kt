package com.richardson.githubbest.webservices

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


const val GET_REPOS = "search/repositories?sort=stars&q=user:"
interface IGithubAPI {

    @Headers("Accept: application/vnd.github.v3+json")
    @GET(GET_REPOS)
    fun getRepos(@Query("q") name: String): Observable<GetReposResponse>
}
