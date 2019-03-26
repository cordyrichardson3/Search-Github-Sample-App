package com.richardson.githubbest.ui.main

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.richardson.githubbest.R
import com.richardson.githubbest.models.GitHubRepo
import com.richardson.githubbest.ui.BaseActivity
import com.richardson.githubbest.ui.showErrorAlert
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.indeterminateProgressDialog


class MainActivity: BaseActivity(), IMainContract.View, RepoClickListener{
    private var loadingDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val presenter = MainPresenter(this)

        //set search view
        sv_company.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                presenter.getReposByCompany(query.toString())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {return false}
        })

        //set search results view
        rv_searchResults.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = ReposAdapter(this@MainActivity)
        }
    }

    override fun updateData(repos: Array<GitHubRepo>) {
        tv_prompt.visibility = View.GONE
        (rv_searchResults.adapter as ReposAdapter).updateData(repos)
    }

    override fun showLoading() {
        if(loadingDialog == null)
            loadingDialog = indeterminateProgressDialog(getString(com.richardson.githubbest.R.string.loading))
        else
            loadingDialog!!.show()
    }

    override fun hideLoading(){
        if(loadingDialog?.isShowing == true)
            loadingDialog!!.hide()
    }

    override fun showError() = showErrorAlert(getString(R.string.error_generic))

    override fun showNoResultsFound() {
        rv_searchResults.visibility = View.GONE
        tv_prompt.visibility = View.VISIBLE
    }

    override fun onRepoItemClick(repoUrl: String) {
        if(!browse(repoUrl))
            showErrorAlert(getString(R.string.error_generic))
    }
}

interface RepoClickListener {
    fun onRepoItemClick(repoUrl: String)

}