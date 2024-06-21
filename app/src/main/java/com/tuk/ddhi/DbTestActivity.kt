package com.tuk.ddhi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tuk.ddhi.databinding.ActivityDbTestBinding

class DbTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bind = ActivityDbTestBinding.inflate(layoutInflater)
        setContentView(bind.root)


    }
}