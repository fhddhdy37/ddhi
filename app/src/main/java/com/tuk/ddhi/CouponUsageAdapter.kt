package com.tuk.ddhi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tuk.ddhi.databinding.ItemCouponUsageBinding

data class CouponUsage(val description: String, val date: String)

class CouponUsageAdapter(private val items: List<CouponUsage>) :
    RecyclerView.Adapter<CouponUsageAdapter.CouponUsageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouponUsageViewHolder {
        val binding = ItemCouponUsageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CouponUsageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CouponUsageViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class CouponUsageViewHolder(private val binding: ItemCouponUsageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CouponUsage) {
            binding.tvDescription.text = item.description
            binding.tvDate.text = item.date
        }
    }
}