package com.tuk.ddhi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tuk.ddhi.databinding.ItemLayoutTagsBinding

class TagListAdapter(private val tags: List<String>) : RecyclerView.Adapter<TagListAdapter.TagViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutTagsBinding.inflate(layoutInflater, parent, false)
        return TagViewHolder(binding)
    }

    override fun getItemCount() = tags.size

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.bind(tags[position])
    }

    class TagViewHolder(private val binding: ItemLayoutTagsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tag: String) {
            binding.tvTag.text = "${tag.trim()} >"
        }
    }
}