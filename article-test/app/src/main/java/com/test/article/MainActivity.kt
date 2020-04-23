package com.test.article

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.article.DetailActivity.Companion.AVATAR
import com.test.article.DetailActivity.Companion.ID
import com.test.article.DetailActivity.Companion.TITLE
import com.test.article.adapter.ArticleAdapter
import com.test.article.databinding.ActivityMainBinding
import com.test.article.model.ArticleResponse

class MainActivity : AppCompatActivity(), ArticleAdapter.ItemClick {

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
        articleAdapter.itemClick = this
    }

    private fun setData() {
        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel::class.java)
        articleViewModel.articles.observe(
            this,
            Observer { articleViewModels: List<ArticleResponse> ->
                articleAdapter.setArticles(articleViewModels)
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
