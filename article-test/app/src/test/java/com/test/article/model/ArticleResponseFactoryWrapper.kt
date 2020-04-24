package com.test.article.model

 class ArticleResponseFactoryWrapper {

    fun convertLongToDate(time: Long): String{
        return ArticleResponseFactory.convertLongToDate(time)
    }
}
