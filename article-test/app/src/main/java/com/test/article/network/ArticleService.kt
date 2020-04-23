package com.test.article.network

import com.test.article.model.ArticleResponse
import retrofit2.Call
import retrofit2.http.GET

interface ArticleService {
    @GET("article")
    fun article(): Call<List<ArticleResponse>>
}
