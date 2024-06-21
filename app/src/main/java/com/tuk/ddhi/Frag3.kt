package com.tuk.ddhi

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class Frag3 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_frag3, container, false)

        val button: Button = view.findViewById(R.id.btnGoToQR)
        button.setOnClickListener {
            val intent = Intent(activity, QRActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}