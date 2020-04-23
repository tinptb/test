package com.test.article

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.test.article.databinding.ActivityDetailBinding
import com.test.article.model.ArticleDetailResponse

class DetailActivity : AppCompatActivity() {

    private lateinit var articleDetailViewModel: ArticleDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setData()
    }

    private fun setData() {
        val activityDetailBinding =
            DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
        articleDetailViewModel = ViewModelProviders.of(
            this,
            ArticleViewModelFactory(this.application, intent.getIntExtra("id", 0))
        ).get(ArticleDetailViewModel::class.java)

        articleDetailViewModel.articleDetail.observe(
            this,
            Observer { articleDetailViewModels: ArticleDetailResponse ->
                activityDetailBinding.articleDetailViewModel = articleDetailViewModels
            })
    }
}
