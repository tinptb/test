package com.test.article.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.test.article.R
import com.test.article.databinding.ActivityDetailBinding
import com.test.article.model.ArticleDetail
import com.test.article.model.ArticleDetailViewModel
import com.test.article.model.factory.ArticleViewModelFactory
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val ID = "id"
        const val TITLE = "title"
        const val DETAIL = "detail"
        const val AVATAR = "avatar"
    }

    private lateinit var articleDetailViewModel: ArticleDetailViewModel
    private var title: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = intent.getStringExtra(TITLE)
        supportActionBar?.title = title
        setData()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_edit, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.edit) {
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra(TITLE, title)
            intent.putExtra(DETAIL, tvText.text)
            startActivity(intent)
        } else {
            onBackPressed()
        }
        return true
    }

    private fun setData() {
        val activityDetailBinding =
            DataBindingUtil.setContentView<ActivityDetailBinding>(
                this,
                R.layout.activity_detail
            )
        activityDetailBinding.loadingVisible = View.VISIBLE

        articleDetailViewModel = ViewModelProviders.of(
            this,
            ArticleViewModelFactory(
                application, intent.getIntExtra(ID, 0)
            )
        ).get(ArticleDetailViewModel::class.java)

        articleDetailViewModel.articleDetail.observe(
            this,
            Observer { articleDetail: ArticleDetail ->
                activityDetailBinding.loadingVisible = View.GONE

                if (articleDetail.articleDetailResponse != null) {
                    activityDetailBinding.articleDetailViewModel =
                        articleDetail.articleDetailResponse
                } else {
                    AlertDialog.Builder(this)
                        .setTitle("Error")
                        .setMessage(articleDetail.error)
                        .setNegativeButton("OK", null)
                        .show()
                }

            })

        activityDetailBinding.avatar = intent.getStringExtra(AVATAR)

    }
}
