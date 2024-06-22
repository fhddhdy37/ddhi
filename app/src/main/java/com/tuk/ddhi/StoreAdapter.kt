package com.tuk.ddhi

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tuk.ddhi.databinding.ItemLayoutStoreBinding

class StoreAdapter : ListAdapter<Store, StoreAdapter.StoreViewHolder>(StoreDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutStoreBinding.inflate(layoutInflater, parent, false)
        return StoreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val storeItem = getItem(position)
        holder.bind(storeItem)
    }

    class StoreViewHolder(private val binding: ItemLayoutStoreBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Store) {
            binding.tvTitle.text = item.title
            Glide.with(binding.root.context).load(item.imageUrl).into(binding.image)

            binding.image.setOnClickListener {
                val context = binding.root.context
                val intent = Intent(context, StoreImActivity::class.java)
                context.startActivity(intent)
            }

            binding.recyclerView2.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = TagListAdapter(item.tags.split(",").map { it.trim() })
            }
        }
    }
}