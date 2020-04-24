package com.test.article.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.test.article.R
import com.test.article.ui.DetailActivity.Companion.DETAIL
import com.test.article.ui.DetailActivity.Companion.TITLE
import com.test.article.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Edit ${intent.getStringExtra(TITLE)}"
        setData()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cancel, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }

    private fun setData() {
        val activityEditBinding =
            DataBindingUtil.setContentView<ActivityEditBinding>(this,
                R.layout.activity_edit
            )
        activityEditBinding.detail = intent.getStringExtra(DETAIL)
        activityEditBinding.editActivity = this
    }

    fun save() {
        finish()
    }
}
