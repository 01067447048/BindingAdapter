package com.jaehyeon.compose.bindingadapter.di

import com.jaehyeon.compose.bindingadapter.data.CoinListDataSource
import com.jaehyeon.compose.bindingadapter.data.impl.CoinListDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideCoinListDataSource(
        retrofit: Retrofit
    ): CoinListDataSource {
        return CoinListDataSourceImpl(retrofit)
    }
}