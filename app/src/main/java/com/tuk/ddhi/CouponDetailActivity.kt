package com.tuk.ddhi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CouponDetailActivity : AppCompatActivity() {
    private lateinit var couponCountTextView: TextView
    private lateinit var storeName: String
    private var couponCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coupon_detail)

        storeName = intent.getStringExtra("storeName") ?: ""
        couponCount = intent.getIntExtra("couponCount", 0)

        findViewById<TextView>(R.id.textView).text = storeName
        couponCountTextView = findViewById(R.id.couponCountTextView)
        couponCountTextView.text = couponCount.toString()

        findViewById<Button>(R.id.btnQRCode).setOnClickListener {
            val intent = Intent(this, QRActivity::class.java)
            startActivityForResult(intent, QR_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == QR_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            couponCountTextView.text = couponCount.toString()
            MenuItemDataManager.updateCouponCount(storeName, couponCount)
            updateHistory()
        }
    }

    private fun updateHistory() {
        // Add logic to update the history view with the new coupon count
        // This could be appending a new entry to a list or updating an existing entry
    }

    companion object {
        const val QR_REQUEST_CODE = 1
    }
}