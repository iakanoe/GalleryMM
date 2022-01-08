package io.github.iakanoe.gallery.ui.common

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ClickableListAdapter<T, H : ClickableListAdapter.ViewHolder<T>>(private val onItemClickListener: OnItemClickListener<T>) :
    RecyclerView.Adapter<H>() {

    var list: List<T> = emptyList()
        @SuppressLint("NotifyDataSetChanged") // long story :(
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: H, position: Int) = holder.bind(list[position], onItemClickListener)
    override fun getItemCount(): Int = list.size

    fun interface OnItemClickListener<T> {
        fun onItemClick(item: T)
    }

    abstract class ViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bindModel(model: T)
        fun bind(model: T, onItemClickListener: OnItemClickListener<T>) {
            itemView.setOnClickListener { onItemClickListener.onItemClick(model) }
            bindModel(model)
        }
    }

}