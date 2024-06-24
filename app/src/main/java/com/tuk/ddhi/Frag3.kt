package com.tuk.ddhi

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Frag3 : Fragment() {

    private lateinit var adapter: CouponMenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_frag3, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.menu_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = CouponMenuAdapter(MenuItemDataManager.getMenuItems()) { menuItem ->
            val intent = Intent(context, CouponDetailActivity::class.java).apply {
                putExtra("storeName", menuItem.name)
                putExtra("couponCount", menuItem.couponCount)
            }
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        val button = view.findViewById<Button>(R.id.menu_button)
        button.setOnClickListener {
            // Handle coupon issue logic here
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}