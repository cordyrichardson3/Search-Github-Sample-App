package com.richardson.githubbest.models

data class GitHubRepo(val name: String?,
                      val html_url: String?,
                      val description: String?,
                      val owner: Owner?) {

    data class Owner(val avatar_url: String?)
}