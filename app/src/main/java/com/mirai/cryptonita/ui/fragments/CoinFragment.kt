package com.mirai.cryptonita.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ConcatAdapter
import com.mirai.cryptonita.R
import com.mirai.cryptonita.core.Resource
import com.mirai.cryptonita.data.model.Coin
import com.mirai.cryptonita.data.model.CoinList
import com.mirai.cryptonita.data.remote.CoinDataSource
import com.mirai.cryptonita.databinding.FragmentCoinBinding
import com.mirai.cryptonita.presentation.CoinViewModel
import com.mirai.cryptonita.presentation.CoinViewModelFactory
import com.mirai.cryptonita.repository.CoinRepositoryImpl
import com.mirai.cryptonita.repository.RetrofitClient
import com.mirai.cryptonita.ui.fragments.adapters.CoinAdapter
import com.mirai.cryptonita.ui.fragments.adapters.concat.CoinsConcatAdapter
import com.mirai.cryptonita.ui.fragments.adapters.concat.ExchangesConcatAdapter
import com.mirai.cryptonita.ui.fragments.adapters.concat.TrendingConcatAdapter


class CoinFragment : Fragment(R.layout.fragment_coin), CoinAdapter.OnCoinClickListener {

    private lateinit var binding: FragmentCoinBinding
    private val viewModel by viewModels<CoinViewModel> {
        CoinViewModelFactory(CoinRepositoryImpl(CoinDataSource(RetrofitClient.webservice)))
    }



    private lateinit var concatAdapter: ConcatAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCoinBinding.bind(view)

        concatAdapter = ConcatAdapter()



        viewModel.fetchMainScreenCrypto().observe(viewLifecycleOwner, Observer {result ->
            when (result){
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    concatAdapter.apply {

                        Log.d("DATAAAA =>", "${result.data.second} ")

                       //addAdapter(0,TrendingConcatAdapter(CoinAdapter(result.data.first.coins, this@CoinFragment)))
                        addAdapter(0,CoinAdapter(result.data.second, this@CoinFragment))
                    }
                }
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Log.d("Error", "${result.exception}")
                }
            }
        })


    }

    override fun onCoinClick(coin: Coin) {
        Log.d("TAG","OnCLICK: $coin")
    }
}