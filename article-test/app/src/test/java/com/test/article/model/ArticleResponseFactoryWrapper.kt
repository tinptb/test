package com.test.article.model

 class ArticleResponseFactoryWrapper {
    private val articleResponseFactoryCompanion get() = ArticleResponseFactory.Companion

    fun convertLongToDate(time: Long): String{
        return articleResponseFactoryCompanion.convertLongToDate(time)
    }
}
