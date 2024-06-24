package com.tuk.ddhi

object MenuItemDataManager {
    private val menuItems = mutableListOf(
        MenuItem("리프리", 5),
        MenuItem("육장인", 3),
        MenuItem("사브리", 1)
    )

    fun getMenuItems(): List<MenuItem> = menuItems

    fun updateCouponCount(name: String, newCount: Int) {
        menuItems.find { it.name == name }?.couponCount = newCount
    }
}