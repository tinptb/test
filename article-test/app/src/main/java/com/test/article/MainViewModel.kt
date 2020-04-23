package com.test.article

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.test.article.model.ArticleRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val articles = ArticleRepository().getMutableLiveData()
}
