package com.jaehyeon.compose.bindingadapter.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jaehyeon.compose.bindingadapter.presentation.model.PresentationCoin
import com.jaehyeon.compose.bindingadapter.presentation.use_case.CoinListUseCase
import com.jaehyeon.compose.bindingadapter.utils.Resource
import com.jaehyeon.compose.bindingadapter.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Created by Jaehyeon on 2022/07/10.
 */
@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val useCase: CoinListUseCase
): ViewModel() {

   data class CoinListState(
       val state: State = State.LOADING,
       val data: List<PresentationCoin> = emptyList(),
       val error: String = ""
   )

    private val _coinListState = MutableStateFlow(CoinListState())
    val coinListState: StateFlow<CoinListState> = _coinListState.asStateFlow()

    private fun getCoins() {
        useCase().onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    _coinListState.value = CoinListState()
                }

                is Resource.Success -> {
                    _coinListState.value = CoinListState(
                        state = State.SUCCESS,
                        error = "",
                        data = result.data ?: emptyList()
                    )
                }

                is Resource.Error -> {
                    _coinListState.value = CoinListState(
                        state = State.ERROR,
                        error = result.message,
                        data = emptyList()
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    init {
        getCoins()
    }
}