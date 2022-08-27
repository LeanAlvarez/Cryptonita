package com.mirai.cryptonita.ui.fragments.adapters.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mirai.cryptonita.core.BaseConcatHolder
import com.mirai.cryptonita.databinding.CoinsMarketRowBinding

class CoinsConcatAdapter(private val coinsConcatAdapter: CoinsConcatAdapter): RecyclerView.Adapter<BaseConcatHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding = CoinsMarketRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder){
            is ConcatViewHolder -> holder.bind(coinsConcatAdapter)
        }
    }

    override fun getItemCount(): Int  = 1

    private inner class ConcatViewHolder(val binding: CoinsMarketRowBinding): BaseConcatHolder<CoinsConcatAdapter>(binding.root) {
        override fun bind(adapter: CoinsConcatAdapter) {
            binding.rvCoins.adapter = adapter
        }
    }


}