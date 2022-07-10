package com.jaehyeon.compose.bindingadapter.di

import com.jaehyeon.compose.bindingadapter.data.CoinListDataSource
import com.jaehyeon.compose.bindingadapter.domain.CoinListRepositoryImpl
import com.jaehyeon.compose.bindingadapter.domain.repository.CoinListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCoinListRepository(
        coinListDataSource: CoinListDataSource
    ): CoinListRepository {
        return CoinListRepositoryImpl(coinListDataSource)
    }

}