package com.test.article.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.text.SimpleDateFormat
import java.util.*

data class Article(val articleResponse: List<ArticleResponse>, val error: String? = null)

data class ArticleResponse(
    val id: Int,
    val title: String,
    val last_update: Long,
    val short_description: String,
    val avatar: String) {

    fun convertLongToDate(time: Long): String {
        return ArticleResponseFactory.convertLongToDate(time)
    }

}


@BindingAdapter("avatar")
fun loadImage(imageView: ImageView, imageURL: String) {
    Glide.with(imageView.context)
        .setDefaultRequestOptions(RequestOptions().circleCrop())
        .load(imageURL)
        .into(imageView)

}
