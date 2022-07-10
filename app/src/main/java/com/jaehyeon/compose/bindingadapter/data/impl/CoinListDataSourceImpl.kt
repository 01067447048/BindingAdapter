package com.jaehyeon.compose.bindingadapter.data.impl

import com.jaehyeon.compose.bindingadapter.data.CoinListDataSource
import com.jaehyeon.compose.bindingadapter.data.response.CoinListResponse
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by Jaehyeon on 2022/07/10.
 */
class CoinListDataSourceImpl @Inject constructor(
    private val retrofit: Retrofit
): CoinListDataSource {

    override suspend fun getCoins(): List<CoinListResponse> {
        return retrofit.create(CoinListDataSource::class.java).getCoins()
    }

}