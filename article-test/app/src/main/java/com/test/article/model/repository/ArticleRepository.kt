package com.test.article.model.repository

import androidx.lifecycle.MutableLiveData
import com.test.article.model.Article
import com.test.article.model.ArticleDetail
import com.test.article.model.ArticleDetailResponse
import com.test.article.model.ArticleResponse
import com.test.article.network.RetrofitClient.Companion.getService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleRepository {

    fun getArticleListLiveData(): MutableLiveData<Article> {
        val articleLiveData = MutableLiveData<Article>()
        getService()
            .article()
            .enqueue(object : Callback<List<ArticleResponse>> {
                override fun onResponse(
                    call: Call<List<ArticleResponse>>,
                    response: Response<List<ArticleResponse>>
                ) {
                    val articles = response.body()
                    if (articles != null) {
                        articleLiveData.value =
                            Article(articles)
                    }
                }

                override fun onFailure(call: Call<List<ArticleResponse>>, t: Throwable) {
                    articleLiveData.value =
                        Article(emptyList(), t.message)
                }
            })
        return articleLiveData
    }

    fun getArticleDetailLiveData(id: Int): MutableLiveData<ArticleDetail> {
        val articleDetailLiveData = MutableLiveData<ArticleDetail>()
        getService()
            .articleDetail(id)
            .enqueue(object : Callback<ArticleDetailResponse> {
                override fun onResponse(
                    call: Call<ArticleDetailResponse>,
                    response: Response<ArticleDetailResponse>
                ) {
                    val articleDetail = response.body()
                    if (articleDetail != null) {
                        articleDetailLiveData.value =
                            ArticleDetail(articleDetail)
                    }
                }

                override fun onFailure(call: Call<ArticleDetailResponse>, t: Throwable) {
                    articleDetailLiveData.value =
                        ArticleDetail(null, t.message)
                }
            })
        return articleDetailLiveData
    }
}
