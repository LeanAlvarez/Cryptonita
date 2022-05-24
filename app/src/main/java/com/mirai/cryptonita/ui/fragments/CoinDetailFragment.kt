package com.mirai.cryptonita.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.mirai.cryptonita.R
import com.mirai.cryptonita.databinding.FragmentCoinDetailBinding


class CoinDetailFragment : Fragment(R.layout.fragment_coin_detail) {

    private lateinit var binding: FragmentCoinDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding = FragmentCoinDetailBinding.bind(view)
    }

}