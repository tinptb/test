package com.test.article

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.test.article.model.ArticleRepository

class ArticleViewModel(application: Application) : AndroidViewModel(application) {
    val articles = ArticleRepository().getArticleListLiveData()
}

class ArticleDetailViewModel(application: Application, id: Int) : AndroidViewModel(application) {
    val articleDetail = ArticleRepository().getArticleDetailLiveData(id)
}
