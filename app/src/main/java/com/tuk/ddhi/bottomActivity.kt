package com.tuk.ddhi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tuk.ddhi.databinding.ActivityBottomBinding

class bottomActivity : AppCompatActivity() {

    private var mBinding: ActivityBottomBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityBottomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavi.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_map -> {
                    setFrag(0)
                    true
                }
                R.id.action_list -> {
                    setFrag(1)
                    true
                }
                R.id.action_coupon -> {
                    setFrag(2)
                    true
                }
                R.id.action_mypage -> {
                    setFrag(3)
                    true
                }
                else -> false
            }
        }
        setFrag(0)
    }

    private fun setFrag(fragNum: Int) {
        val ft = supportFragmentManager.beginTransaction()

        when (fragNum) {
            0 -> {
                ft.replace(R.id.main_frame, MapsFragment()).commitNow()
            }
            1 -> {
                ft.replace(R.id.main_frame, Frag2()).commitNow()
            }
            2 -> {
                ft.replace(R.id.main_frame, Frag3()).commitNow()
            }
            3 -> {
                ft.replace(R.id.main_frame, Frag4()).commitNow()
            }
        }
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}