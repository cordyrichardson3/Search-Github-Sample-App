package com.richardson.githubbest.ui.main

import com.richardson.githubbest.webservices.ReposRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers


class MainPresenter (val mView: IMainContract.View): IMainContract.Presenter {
    private val repository: ReposRepository by lazy{ ReposRepository() }

    override fun getReposByCompany(query: String) {
        mView.showLoading()
        repository.fetchRepos(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {mView.apply{hideLoading(); updateData(it.items.take(3).toTypedArray())}},
                onError ={mView.apply{hideLoading(); showError()}}
            )
    }
}