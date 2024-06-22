package com.tuk.ddhi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuk.ddhi.databinding.FragmentFrag2Binding

class Frag2 : Fragment() {

    private lateinit var binding: FragmentFrag2Binding
    private lateinit var storeAdapter: StoreAdapter
    private lateinit var storeVM: StoreVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment using View Binding
        binding = FragmentFrag2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        storeAdapter = StoreAdapter()
        binding.recyclerView2.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = storeAdapter
        }

        storeVM = ViewModelProvider(this).get(StoreVM::class.java)
        storeVM.storeList.observe(viewLifecycleOwner, Observer {
            storeAdapter.submitList(it)
        })

        storeVM.getfakestoreList()
    }
}