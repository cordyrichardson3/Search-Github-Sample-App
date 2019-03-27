package com.richardson.githubbest.ui.main

import com.richardson.githubbest.App
import com.richardson.githubbest.webservices.ReposRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainPresenter @Inject constructor (val mView: IMainContract.View): IMainContract.Presenter {
    private val repository: ReposRepository by lazy{ App().dataAccessComponent.getRepository() }
    private val MAX_ITEMS = 3

    override fun getReposByCompany(query: String) {
        mView.showLoading()
        repository.fetchRepos(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    mView.apply{hideLoading()
                        if(it.items.isNullOrEmpty())
                            mView.showNoResultsFound()
                        else
                            updateData(it.items.take(MAX_ITEMS).toTypedArray())
                    }},
                onError ={mView.apply{hideLoading(); showError()}}
            )
    }
}