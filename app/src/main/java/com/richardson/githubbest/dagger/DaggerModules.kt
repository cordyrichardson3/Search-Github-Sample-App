package com.richardson.githubbest.dagger

import com.richardson.githubbest.ui.main.*
import com.richardson.githubbest.webservices.GithubRepoRetrofit
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class MainViewsModule(val activity: MainActivity){
    @MainActivityScope @Provides
    fun getReposAdapter(): ReposAdapter = ReposAdapter(activity as RepoClickListener)

    @MainActivityScope @Provides
    fun getPresenter(): MainPresenter = MainPresenter(activity as IMainContract.View)
}


@Module
class RetrofitModule {
    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit {
        return GithubRepoRetrofit().getRetrofitInstance()
    }
}