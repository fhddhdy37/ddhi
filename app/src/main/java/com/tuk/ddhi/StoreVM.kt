package com.tuk.ddhi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StoreVM : ViewModel() {
    private val _storeList: MutableLiveData<List<Store>> = MutableLiveData()
    val storeList: LiveData<List<Store>>
        get() = _storeList

    fun getfakestoreList() {
        viewModelScope.launch {
            withContext(IO) {
                _storeList.postValue(StoreRepositoryImpl.getStoreItems())
            }
        }
    }
}