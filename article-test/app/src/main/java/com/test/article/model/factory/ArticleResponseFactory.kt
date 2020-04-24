package com.test.article.model.factory

import java.text.SimpleDateFormat
import java.util.*

class ArticleResponseFactory {
    companion object {
        fun convertLongToDate(time: Long): String {
            val date = Date(time * 1000)
            val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            return format.format(date)
        }
    }
}


