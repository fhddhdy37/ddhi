package com.tuk.ddhi

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class Frag2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_frag2, container, false)

        val btnCategory: Button = view.findViewById(R.id.btnCategory)
        val btnSort: Button = view.findViewById(R.id.btnSort)

        btnCategory.setOnClickListener {
            Toast.makeText(activity, "카테고리 버튼 클릭", Toast.LENGTH_SHORT).show()
            // Implement category selection
        }

        btnSort.setOnClickListener {
            Toast.makeText(activity, "정렬 버튼 클릭", Toast.LENGTH_SHORT).show()
            // Implement sorting
        }


        val storeInfoTextView1: TextView = view.findViewById(R.id.storeInfoTextView1)
        storeInfoTextView1.setOnClickListener {
            val intent = Intent(activity, StoreImActivity::class.java)
            startActivity(intent)
        }

        val storeInfoTextView2: TextView = view.findViewById(R.id.storeInfoTextView2)
        storeInfoTextView2.setOnClickListener {
            val intent = Intent(activity, StoreImActivity::class.java)
            startActivity(intent)
        }

        val storeInfoTextView3: TextView = view.findViewById(R.id.storeInfoTextView3)
        storeInfoTextView2.setOnClickListener {
            val intent = Intent(activity, StoreImActivity::class.java)
            startActivity(intent)
        }

        val storeInfoTextView4: TextView = view.findViewById(R.id.storeInfoTextView4)
        storeInfoTextView2.setOnClickListener {
            val intent = Intent(activity, StoreImActivity::class.java)
            startActivity(intent)
        }

        val storeInfoTextView5: TextView = view.findViewById(R.id.storeInfoTextView5)
        storeInfoTextView2.setOnClickListener {
            val intent = Intent(activity, StoreImActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}

