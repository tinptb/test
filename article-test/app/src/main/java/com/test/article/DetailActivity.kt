package com.test.article

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.test.article.databinding.ActivityDetailBinding
import com.test.article.model.ArticleDetailResponse

class DetailActivity : AppCompatActivity() {

    companion object {
        const val ID = "id"
        const val TITLE = "title"
        const val AVATAR = "avatar"
    }

    private lateinit var articleDetailViewModel: ArticleDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = intent.getStringExtra(TITLE)
        setData()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.edit){
            Toast.makeText(this, "edit", Toast.LENGTH_LONG).show()
        }
        return true
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
