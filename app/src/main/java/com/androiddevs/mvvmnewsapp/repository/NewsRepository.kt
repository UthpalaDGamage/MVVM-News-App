package com.androiddevs.mvvmnewsapp.repository

import androidx.lifecycle.ViewModel
import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.models.Article

class NewsRepository(
    val db:ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun searchNews(searchKey:String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchKey, pageNumber)

    suspend fun upsertArticle(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedArticles() = db.getArticleDao().getAllAticles()

    suspend fun deleteArticle(article:Article) = db.getArticleDao().deleteArticle(article)
}