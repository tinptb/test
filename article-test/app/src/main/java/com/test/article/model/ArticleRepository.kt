package com.test.article.model

import androidx.lifecycle.MutableLiveData
import com.test.article.network.RetrofitClient.Companion.getService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleRepository {

    fun getArticleListLiveData(): MutableLiveData<List<ArticleResponse>> {
        val articleLiveData = MutableLiveData<List<ArticleResponse>>()
        getService()
            .article()
            .enqueue(object : Callback<List<ArticleResponse>> {
                override fun onResponse(
                    call: Call<List<ArticleResponse>>,
                    response: Response<List<ArticleResponse>>
                ) {
                    val articles = response.body()
                    if (articles != null) {
                        articleLiveData.value = articles
                    }
                }

                override fun onFailure(call: Call<List<ArticleResponse>>, t: Throwable) {}
            })
        return articleLiveData
    }

    fun getArticleDetailLiveData(id: Int): MutableLiveData<ArticleDetailResponse> {
        val articleDetailLiveData = MutableLiveData<ArticleDetailResponse>()
        getService()
            .articleDetail(id)
            .enqueue(object : Callback<ArticleDetailResponse> {
                override fun onResponse(
                    call: Call<ArticleDetailResponse>,
                    response: Response<ArticleDetailResponse>
                ) {
                    val articles = response.body()
                    if (articles != null) {
                        articleDetailLiveData.value = articles
                    }
                }

                override fun onFailure(call: Call<ArticleDetailResponse>, t: Throwable) {}
            })
        return articleDetailLiveData
    }
}
