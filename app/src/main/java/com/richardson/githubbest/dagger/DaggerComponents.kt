package com.richardson.githubbest.dagger

import com.richardson.githubbest.ui.main.MainPresenter
import com.richardson.githubbest.ui.main.ReposAdapter
import com.richardson.githubbest.webservices.ReposRepository
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface DataAccessComponent {
    fun getRepository(): ReposRepository
    fun getRetrofitInstance(): Retrofit
}

@MainActivityScope
@Component(modules = [MainViewsModule::class])
interface MainViewsComponent {
    fun getPresenter(): MainPresenter
    fun getReposAdapter(): ReposAdapter

}
