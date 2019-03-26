package com.richardson.githubbest.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.richardson.githubbest.R
import com.richardson.githubbest.models.GitHubRepo
import kotlinx.android.synthetic.main.repo_list_item.view.*

class ReposAdapter(val repoClickListener: RepoClickListener): RecyclerView.Adapter<ReposAdapter.RepoViewHolder>() {
    private var reposArray: Array<GitHubRepo>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            RepoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.repo_list_item, parent, false))

    override fun getItemCount(): Int = reposArray?.size ?: 0

    override fun onBindViewHolder(holder:RepoViewHolder, pos: Int){
        reposArray?.let{
            with(it.get(pos)){
                with(holder){
                    tv_title.text = name
                    tv_description.text = description

                    Glide.with(holder.itemView)
                        .load(owner?.avatar_url)
                        .into(iv_logo)

                    itemView.setOnClickListener({repoClickListener.onRepoItemClick(html_url.toString())})
                }
            }
        }
    }

    fun updateData(repos: Array<GitHubRepo>){
        reposArray = repos
        notifyDataSetChanged()
    }


    class RepoViewHolder(view: View): RecyclerView.ViewHolder(view){
        val iv_logo = view.iv_logo
        val tv_title = view.tv_title
        val tv_description = view.tv_description
    }
}