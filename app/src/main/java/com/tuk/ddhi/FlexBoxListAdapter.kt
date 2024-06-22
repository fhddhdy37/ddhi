package com.tuk.ddhi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tuk.ddhi.databinding.ItemLayoutTagsBinding

class FlexBoxListAdapter(val list: List<String>) : RecyclerView.Adapter<FlexBoxListAdapter.TagsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutTagsBinding.inflate(layoutInflater, parent, false)
        return TagsViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: TagsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class TagsViewHolder(private val binding: ItemLayoutTagsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tag: String) {
            binding.tvTag.text = "${tag.trim()} >"
        }
    }
}