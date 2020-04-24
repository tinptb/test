package com.test.article.model.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.article.model.ArticleDetailViewModel

class ArticleViewModelFactory(private val application: Application, private val id: Int) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArticleDetailViewModel(application, id) as T
    }

}
