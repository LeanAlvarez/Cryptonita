package com.mirai.cryptonita.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.mirai.cryptonita.core.Resource
import com.mirai.cryptonita.repository.CoinRepository
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import java.lang.Exception

class CoinViewModel(private val repo: CoinRepository): ViewModel() {

    fun fetchMainScreenCrypto() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
             emit(Resource.Success(Triple(repo.getTrending(), repo.getCoins(), repo.getExchanges())))
        }catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }



}




class CoinViewModelFactory(private val repo: CoinRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(CoinRepository::class.java).newInstance(repo)
    }

}