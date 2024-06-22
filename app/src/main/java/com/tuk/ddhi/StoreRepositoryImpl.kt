package com.tuk.ddhi

object StoreRepositoryImpl : StoreRepository {

    override suspend fun getStoreItems(): List<Store> {
        return fakestoreList
    }
}