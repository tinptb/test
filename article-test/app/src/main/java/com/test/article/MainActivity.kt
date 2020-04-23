package com.test.article

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.article.adapter.ArticleAdapter
import com.test.article.databinding.ActivityMainBinding
import com.test.article.model.ArticleResponse

class MainActivity : AppCompatActivity() {

    private lateinit var articleViewModel: ArticleViewModel
    private lateinit var articleAdapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
        setData()
    }

    private fun setupRecyclerView() {
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val recyclerView = activityMainBinding.viewArticles
        recyclerView.layoutManager = LinearLayoutManager(this)
        articleAdapter = ArticleAdapter()
        recyclerView.adapter = articleAdapter
    }

    private fun setData() {
        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel::class.java)
        articleViewModel.articles.observe(
            this,
            Observer { articleViewModels: List<ArticleResponse> ->
                articleAdapter.setArticles(articleViewModels)
            })
    }
}
