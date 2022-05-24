package com.mirai.cryptonita.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.mirai.cryptonita.R
import com.mirai.cryptonita.databinding.FragmentCoinBinding


class CoinFragment : Fragment(R.layout.fragment_coin) {

    private lateinit var binding: FragmentCoinBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCoinBinding.bind(view)

        binding.progressBar.visibility = View.GONE


    }
}