package com.jaehyeon.compose.bindingadapter.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jaehyeon.compose.bindingadapter.databinding.ItemCoinListBinding
import com.jaehyeon.compose.bindingadapter.presentation.model.PresentationCoin

/**
 * Created by Jaehyeon on 2022/07/10.
 */
class CoinListAdapter(private val list: List<PresentationCoin>): RecyclerView.Adapter<CoinListAdapter.CoinViewHolder>() {

    inner class CoinViewHolder(private val binding: ItemCoinListBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(presentationCoin: PresentationCoin) {
            binding.item = presentationCoin
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder =
        CoinViewHolder(ItemCoinListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}