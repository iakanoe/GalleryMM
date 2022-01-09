package io.github.iakanoe.gallery.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import io.github.iakanoe.gallery.databinding.MainActivityBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityBinding.inflate(layoutInflater).run {
            setContentView(root)
            setSupportActionBar(toolbar)
        }
    }

    fun setBackButtonVisibility(visible: Boolean) = supportActionBar?.setDisplayHomeAsUpEnabled(visible)

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId != android.R.id.home) return super.onOptionsItemSelected(item)
        onBackPressed()
        return true
    }
}