package com.jaehyeon.compose.bindingadapter.di

import com.jaehyeon.compose.bindingadapter.domain.repository.CoinListRepository
import com.jaehyeon.compose.bindingadapter.presentation.use_case.CoinListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideCoinListUseCase(
        repository: CoinListRepository
    ): CoinListUseCase {
        return CoinListUseCase(repository)
    }

}