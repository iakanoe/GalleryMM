package io.github.iakanoe.gallery.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import io.github.iakanoe.gallery.R
import io.github.iakanoe.gallery.databinding.MainActivityBinding
import io.github.iakanoe.gallery.ui.collection.CollectionFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityBinding.inflate(layoutInflater).run {
            setContentView(root)
            setSupportActionBar(toolbar)

            // TODO remove all after this comment, replace with navigation component
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, CollectionFragment())
                    .commitNow()
            }
        }
    }
}