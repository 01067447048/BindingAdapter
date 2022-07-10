package com.jaehyeon.compose.bindingadapter.presentation.use_case

import com.jaehyeon.compose.bindingadapter.domain.repository.CoinListRepository
import com.jaehyeon.compose.bindingadapter.presentation.model.PresentationCoin
import com.jaehyeon.compose.bindingadapter.presentation.model.toPresentationCoin
import com.jaehyeon.compose.bindingadapter.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

/**
 * Created by Jaehyeon on 2022/07/10.
 */
class CoinListUseCase @Inject constructor(
    private val repository: CoinListRepository
) {

    operator fun invoke(): Flow<Resource<List<PresentationCoin>>> = flow {
        try {
            emit(Resource.Loading<List<PresentationCoin>>())
            val coins = repository.getCoinList().map { it.toPresentationCoin() }
            emit(Resource.Success<List<PresentationCoin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<PresentationCoin>>(e.localizedMessage ?: "알 수 없는 오류 입니다."))
        } catch (e: IOException) {
            emit(Resource.Error<List<PresentationCoin>>("서버와 연결 할 수 없습니다. 모바일 데이터나 Wi-Fi를 확인 해주세요."))
        }
    }

}