package com.test.article.network

import com.test.article.model.ArticleDetailResponse
import com.test.article.model.ArticleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticleService {
    @GET("article")
    fun article(): Call<List<ArticleResponse>>

    @GET("article/{id}")
    fun articleDetail(@Path("id") id: Int): Call<ArticleDetailResponse>
}
