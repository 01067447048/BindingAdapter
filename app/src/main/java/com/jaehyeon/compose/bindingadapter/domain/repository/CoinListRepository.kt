package com.jaehyeon.compose.bindingadapter.domain.repository

import com.jaehyeon.compose.bindingadapter.domain.model.DomainCoin

/**
 * Created by Jaehyeon on 2022/07/10.
 */
interface CoinListRepository {

    suspend fun getCoinList(): List<DomainCoin>
}