package com.test.article.model

data class ArticleDetail(val articleDetailResponse: ArticleDetailResponse?, val error: String? = null)

data class ArticleDetailResponse(val id: Int, val text: String)

