package com.test.article.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.article.R
import com.test.article.databinding.ArticleItemBinding
import com.test.article.model.ArticleResponse
import java.util.*

class ArticleAdapter : RecyclerView.Adapter<ArticleViewHolder>() {
    private var articles: List<ArticleResponse> = ArrayList()
    var itemClick: ItemClick? = null
        set(value) {
            field = value
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ArticleViewHolder {
        val articleItemBinding: ArticleItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            R.layout.article_item, viewGroup, false)


        return ArticleViewHolder(articleItemBinding)
    }

    override fun onBindViewHolder(articleViewHolder: ArticleViewHolder, i: Int) {
        articleViewHolder.articleItemBinding.articleViewModel = articles[i]
        articleViewHolder.itemView.setOnClickListener {
            itemClick?.click(articles[i].id)
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    fun setArticles(articleViewModels: List<ArticleResponse>) {
        articles = articleViewModels
        notifyDataSetChanged()
    }

    interface ItemClick{
        fun click(id: Int)
    }
}
