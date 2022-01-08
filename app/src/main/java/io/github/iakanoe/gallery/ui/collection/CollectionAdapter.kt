package io.github.iakanoe.gallery.ui.collection

import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.iakanoe.gallery.databinding.CollectionItemBinding
import io.github.iakanoe.gallery.domain.model.Album
import io.github.iakanoe.gallery.ui.common.ClickableListAdapter

class CollectionAdapter(onItemClickListener: OnItemClickListener<Album>) :
    ClickableListAdapter<Album, CollectionAdapter.ViewHolder>(onItemClickListener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CollectionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: CollectionItemBinding) : ClickableListAdapter.ViewHolder<Album>(binding.root) {
        override fun bindModel(model: Album) {
            binding.album = model
        }
    }
}