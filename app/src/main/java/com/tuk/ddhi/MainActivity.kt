package com.tuk.ddhi

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.database.FirebaseDatabase
import com.tuk.ddhi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val REQUEST_LOCATION_PERMISSION = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val dbRef = FirebaseDatabase.getInstance()
        Log.d("d", "${dbRef.getReference("DDHI")}")

        bind.btn1.setOnClickListener {
            val intent = Intent(this, SplashActivity::class.java)
            startActivity(intent)
        }
        bind.btn2.setOnClickListener {
            val intent = Intent(this, BottomActivity::class.java)
            startActivity(intent)
        }
        bind.btn3.setOnClickListener {
            val intent = Intent(this, CouponDetailActivity::class.java)
            startActivity(intent)
        }

    }

    private fun requestLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_LOCATION_PERMISSION)
        }
    }
}