package com.test.article.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.test.article.repository.ArticleRepository

class ArticleViewModel(application: Application) : AndroidViewModel(application) {
    val articles = ArticleRepository().getArticleListLiveData()
}

class ArticleDetailViewModel(application: Application, id: Int) : AndroidViewModel(application) {
    val articleDetail = ArticleRepository().getArticleDetailLiveData(id)
}
