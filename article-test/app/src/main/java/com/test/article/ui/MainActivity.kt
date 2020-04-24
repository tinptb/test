package com.test.article.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.article.ArticleViewModel
import com.test.article.R
import com.test.article.ui.DetailActivity.Companion.AVATAR
import com.test.article.ui.DetailActivity.Companion.ID
import com.test.article.ui.DetailActivity.Companion.TITLE
import com.test.article.adapter.ArticleAdapter
import com.test.article.databinding.ActivityMainBinding
import com.test.article.model.Article

class MainActivity : AppCompatActivity(), ArticleAdapter.ItemClick {

    private lateinit var articleViewModel: ArticleViewModel
    private lateinit var articleAdapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setData()
    }

    private fun setData() {
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this,
                R.layout.activity_main
            )

        activityMainBinding.loadingVisible = View.VISIBLE
        val recyclerView = activityMainBinding.viewArticles
        recyclerView.layoutManager = LinearLayoutManager(this)
        articleAdapter = ArticleAdapter()
        recyclerView.adapter = articleAdapter
        articleAdapter.itemClick = this

        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel::class.java)
        articleViewModel.articles.observe(
            this,
            Observer { article: Article ->
                activityMainBinding.loadingVisible = View.GONE
                if (article.articleResponse.isNotEmpty()) {
                    articleAdapter.setArticles(article.articleResponse)
                } else {
                    AlertDialog.Builder(this)
                        .setTitle("Error")
                        .setMessage(article.error)
                        .setNegativeButton("OK", null)
                        .show()
                }
            })
    }

    override fun click(id: Int, title: String, imageUrl: String) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(ID, id)
        intent.putExtra(AVATAR, imageUrl)
        intent.putExtra(TITLE, title)
        startActivity(intent)
    }
}
