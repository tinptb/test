package com.test.article

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.test.article.databinding.ActivityDetailBinding
import com.test.article.model.ArticleDetailResponse

class DetailActivity : AppCompatActivity() {

    companion object {
        const val ID = "id"
        const val AVATAR = "avatar"
    }

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
            ArticleViewModelFactory(
                this.application,
                intent.getIntExtra(ID, 0)
            )
        ).get(ArticleDetailViewModel::class.java)

        articleDetailViewModel.articleDetail.observe(
            this,
            Observer { articleDetailResponse: ArticleDetailResponse ->
                activityDetailBinding.articleDetailViewModel = articleDetailResponse
            })

        activityDetailBinding.avatar = intent.getStringExtra(AVATAR)

    }
}
