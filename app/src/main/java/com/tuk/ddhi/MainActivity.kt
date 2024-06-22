package com.tuk.ddhi

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.tuk.ddhi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val REQUEST_LOCATION_PERMISSION = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        // Launch bottomActivity
        val intent = Intent(this, bottomActivity::class.java)
        startActivity(intent)
        finish()  // Close MainActivity so that the back button doesn't return to it

        requestLocationPermission()

        bind.btn4.setOnClickListener {
            var intent = Intent(this, QRActivity::class.java)
            startActivity(intent)
        }
        bind.db.setOnClickListener {
            var intent = Intent(this, DbTestActivity::class.java)
            startActivity(intent)
        }
    }

    private fun requestLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_LOCATION_PERMISSION)
        }
    }
}