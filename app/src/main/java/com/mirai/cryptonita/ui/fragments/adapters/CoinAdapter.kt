package com.mirai.cryptonita.ui.fragments.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.JsonArray
import com.mirai.cryptonita.core.BaseViewHolder
import com.mirai.cryptonita.data.model.Coin
import com.mirai.cryptonita.data.model.Exchanges
import com.mirai.cryptonita.data.model.Trending
import com.mirai.cryptonita.databinding.CoinItemBinding

class CoinAdapter(private val coinList: List<Coin>, private val itemClickListener: OnCoinClickListener): RecyclerView.Adapter<BaseViewHolder<*>>() {


    interface OnCoinClickListener {
        fun onCoinClick(coin:Coin)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = CoinItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = CoinViewHolder(itemBinding, parent.context)


        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                ?: return@setOnClickListener
            itemClickListener.onCoinClick(coinList[position])
        }

        return holder

    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder) {
            is CoinViewHolder -> holder.bind(coinList[position])
        }
    }

    override fun getItemCount(): Int = coinList.size

    private inner class CoinViewHolder(val binding: CoinItemBinding, val context: Context) : BaseViewHolder<Coin>(binding.root){
        override fun bind(item: Coin) {
            Glide.with(context).load(item.image).centerCrop().into(binding.imgCoins)
            binding.txtCoin.text = item.name
            binding.txtPrice.text = item.current_price.toString()
            binding.txtMktCapRank.text = item.market_cap_rank.toString()
           // binding.txtHigh.text = item.high_24h.toString()
           // binding.txtLow.text = item.low_24h.toString()
        }

    }



}