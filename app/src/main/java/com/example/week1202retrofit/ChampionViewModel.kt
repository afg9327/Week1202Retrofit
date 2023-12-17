package com.example.week1202retrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChampionViewModel: ViewModel() {
    private val SERVER_URL = "https://port-0-specialback-5yc2g32mlomgpihs.sel5.cloudtype.app/"
    private val lolApi: LolApi
    private val _championList = MutableLiveData<List<Champion>>()
    val championList: LiveData<List<Champion>>
        get() = _championList

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        lolApi = retrofit.create(LolApi::class.java)
        fetchData()
    }

    private fun fetchData() {
        // Coroutine 사용
        viewModelScope.launch {
            try {
                val response = lolApi.getChampions()
                _championList.value = response
            } catch (e: Exception) {
                Log.e("fetchData()", e.toString())
            }
        }
    }
}