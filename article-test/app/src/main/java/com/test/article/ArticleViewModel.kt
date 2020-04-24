package com.test.article

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class ArticleViewModel(application: Application) : AndroidViewModel(application) {
    val articles = ArticleRepository().getArticleListLiveData()
}

class ArticleDetailViewModel(application: Application, id: Int) : AndroidViewModel(application) {
    val articleDetail = ArticleRepository().getArticleDetailLiveData(id)
}
