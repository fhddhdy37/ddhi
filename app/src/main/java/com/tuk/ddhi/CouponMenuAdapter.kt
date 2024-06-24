package com.tuk.ddhi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tuk.ddhi.databinding.ItemStoreBinding

class CouponMenuAdapter(
    private val menuItemList: List<MenuItem>,
    private val onItemClicked: (MenuItem) -> Unit
) : RecyclerView.Adapter<CouponMenuAdapter.MenuItemViewHolder>() {

    inner class MenuItemViewHolder(private val binding: ItemStoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(menuItem: MenuItem) {
            binding.storeName.text = menuItem.name
            binding.couponCount.text = menuItem.couponCount.toString()
            binding.root.setOnClickListener {
                onItemClicked(menuItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStoreBinding.inflate(inflater, parent, false)
        return MenuItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        holder.bind(menuItemList[position])
    }

    override fun getItemCount(): Int = menuItemList.size
}