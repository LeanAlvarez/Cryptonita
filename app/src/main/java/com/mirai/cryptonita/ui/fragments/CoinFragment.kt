package com.mirai.cryptonita.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.mirai.cryptonita.R
import com.mirai.cryptonita.core.Resource
import com.mirai.cryptonita.data.remote.CoinDataSource
import com.mirai.cryptonita.databinding.FragmentCoinBinding
import com.mirai.cryptonita.presentation.CoinViewModel
import com.mirai.cryptonita.presentation.CoinViewModelFactory
import com.mirai.cryptonita.repository.CoinRepositoryImpl
import com.mirai.cryptonita.repository.RetrofitClient
import com.mirai.cryptonita.repository.WebService
import kotlin.math.log


class CoinFragment : Fragment(R.layout.fragment_coin) {

    private lateinit var binding: FragmentCoinBinding
    private val viewModel by viewModels<CoinViewModel> {
        CoinViewModelFactory(CoinRepositoryImpl(CoinDataSource(RetrofitClient.webservice)))
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCoinBinding.bind(view)

        binding.progressBar.visibility = View.GONE

        viewModel.fetchMainScreenCrypto().observe(viewLifecycleOwner, Observer {result ->
            when (result){
                is Resource.Loading -> {
                    Log.d("LiveData", "Loading...")
                }
                is Resource.Success -> {
                    Log.d("LiveData Success", "Trending: ${result.data.first} \n \n Coins: ${result.data.second} \n \n Exchanges: ${result.data.third}")
                }
                is Resource.Failure -> {
                    Log.d("Error", "${result.exception}")
                }
            }
        })


    }
}