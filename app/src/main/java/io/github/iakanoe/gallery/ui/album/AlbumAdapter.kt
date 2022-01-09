package io.github.iakanoe.gallery.ui.album

import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.iakanoe.gallery.databinding.AlbumItemBinding
import io.github.iakanoe.gallery.domain.model.Photo
import io.github.iakanoe.gallery.ui.common.ClickableListAdapter

class AlbumAdapter(onItemClickListener: OnItemClickListener<Photo>) :
    ClickableListAdapter<Photo, AlbumAdapter.ViewHolder>(onItemClickListener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AlbumItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: AlbumItemBinding) : ClickableListAdapter.ViewHolder<Photo>(binding.root) {
        override fun bindModel(model: Photo) {
            binding.photo = model
        }
    }
}