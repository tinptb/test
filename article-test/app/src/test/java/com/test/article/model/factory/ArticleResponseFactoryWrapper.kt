package com.test.article.model.factory

class ArticleResponseFactoryWrapper {

    fun convertLongToDate(time: Long): String {
        return ArticleResponseFactory.convertLongToDate(time)
    }
}
