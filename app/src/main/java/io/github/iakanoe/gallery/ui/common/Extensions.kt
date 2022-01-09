package io.github.iakanoe.gallery.ui.common

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("srcURL")
fun AppCompatImageView.loadImage(srcURL: String) {
    Picasso.get().load(srcURL).placeholder(drawable).into(this)
}