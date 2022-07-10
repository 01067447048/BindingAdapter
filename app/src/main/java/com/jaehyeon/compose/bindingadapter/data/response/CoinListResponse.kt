package com.jaehyeon.compose.bindingadapter.data.response

import com.google.gson.annotations.SerializedName
import com.jaehyeon.compose.bindingadapter.domain.model.DomainCoin

data class CoinListResponse(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinListResponse.toDomainCoin(): DomainCoin = DomainCoin(
    isActive, isNew, name, rank, symbol, id
)