package com.jaehyeon.compose.bindingadapter.domain

import com.jaehyeon.compose.bindingadapter.data.CoinListDataSource
import com.jaehyeon.compose.bindingadapter.data.response.toDomainCoin
import com.jaehyeon.compose.bindingadapter.domain.model.DomainCoin
import com.jaehyeon.compose.bindingadapter.domain.repository.CoinListRepository
import javax.inject.Inject

/**
 * Created by Jaehyeon on 2022/07/10.
 */
class CoinListRepositoryImpl @Inject constructor(
    private val api: CoinListDataSource
): CoinListRepository {

    override suspend fun getCoinList(): List<DomainCoin> {
        return api.getCoins().filter { it.type == "coin" }.map { it.toDomainCoin() }
    }

}