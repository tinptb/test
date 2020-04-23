package com.test.article.model

import androidx.lifecycle.MutableLiveData
import com.test.article.network.RetrofitClient.Companion.getService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleRepository {
    private val mutableLiveData = MutableLiveData<List<ArticleResponse>>()
    fun getMutableLiveData(): MutableLiveData<List<ArticleResponse>> {
        getService()
            .article()
            .enqueue(object : Callback<List<ArticleResponse>?> {
                override fun onResponse(
                    call: Call<List<ArticleResponse>?>,
                    response: Response<List<ArticleResponse>?>
                ) {
                    val articles = response.body()
                    if (articles != null) {
                        mutableLiveData.value = articles
                    }
                }

                override fun onFailure(call: Call<List<ArticleResponse>?>, t: Throwable) {}
            })
        return mutableLiveData
    }
}
