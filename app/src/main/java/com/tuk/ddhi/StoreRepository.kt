package com.tuk.ddhi

interface StoreRepository {
    suspend fun getStoreItems(): List<Store>
}