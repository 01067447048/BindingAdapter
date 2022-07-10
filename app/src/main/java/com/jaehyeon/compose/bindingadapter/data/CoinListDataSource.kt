package com.jaehyeon.compose.bindingadapter.data

import com.jaehyeon.compose.bindingadapter.data.response.CoinListResponse
import retrofit2.http.GET

/**
 * Created by Jaehyeon on 2022/07/10.
 */
interface CoinListDataSource {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinListResponse>
}