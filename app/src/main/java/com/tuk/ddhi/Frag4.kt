package com.tuk.ddhi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuk.ddhi.databinding.FragmentFrag4Binding

class Frag4 : Fragment() {

    private var _binding: FragmentFrag4Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentFrag4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val couponList = listOf(
            CouponUsage("OO피자", "2024-01-15"),
            CouponUsage("어쩌구저쩌구스테이크", "2024-02-10"),
            CouponUsage("ODOXDOX치킨", "2024-03-20"),
            CouponUsage("어쩌구저쩌구", "2024-05-10"),
        )

        val adapter = CouponUsageAdapter(couponList)
        binding.recyclerViewCoupons.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewCoupons.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}