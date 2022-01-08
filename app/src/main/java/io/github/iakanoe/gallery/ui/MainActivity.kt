package io.github.iakanoe.gallery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.iakanoe.gallery.R
import io.github.iakanoe.gallery.ui.collection.CollectionFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CollectionFragment.newInstance())
                .commitNow()
        }
    }
}