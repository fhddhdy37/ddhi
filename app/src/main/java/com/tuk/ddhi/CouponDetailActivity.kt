package com.tuk.ddhi

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CouponDetailActivity : AppCompatActivity() {

    private lateinit var llHistory: LinearLayout
    private lateinit var btnCreditHistory: Button
    private lateinit var btnDebitHistory: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coupon_detail)


        llHistory = findViewById(R.id.llHistory)
        btnCreditHistory = findViewById(R.id.btnCreditHistory)
        btnDebitHistory = findViewById(R.id.btnDebitHistory)

        btnCreditHistory.setOnClickListener {
            loadCreditHistory()
        }

        btnDebitHistory.setOnClickListener {
            loadDebitHistory()
        }

        // Load default history
        loadCreditHistory()
    }
    private fun loadCreditHistory() {
        llHistory.removeAllViews()
        // Add credit history items
        for (i in 1..10) {
            val textView = TextView(this)
            textView.text = "적립 내역 $i"
            llHistory.addView(textView)
        }
    }

    private fun loadDebitHistory() {
        llHistory.removeAllViews()
        // Add debit history items
        for (i in 1..10) {
            val textView = TextView(this)
            textView.text = "차감 내역 $i"
            llHistory.addView(textView)
        }
    }
}