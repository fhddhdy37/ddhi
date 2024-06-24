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
            CouponUsage("명륜진사갈비", "2024-01-15"),
            CouponUsage("샤브린", "2024-02-10"),
            CouponUsage("신오돌불닭발", "2024-03-20"),
            CouponUsage("육장인", "2024-05-10"),
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