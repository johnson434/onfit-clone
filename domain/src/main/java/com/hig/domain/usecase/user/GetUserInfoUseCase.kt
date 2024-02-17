package com.hig.domain.usecase.user

import com.hig.common.exception.UserNotFoundException
import com.hig.common.model.UserDto
import com.hig.domain.data.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetUserInfoUseCase(
    private val userRepository: UserRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend operator fun invoke(userNo: String): Result<UserDto> = withContext(dispatcher) {
        runCatching {
            userRepository.getUserInfo(userNo = userNo) ?: throw UserNotFoundException(message = "존재하지 않는 유저입니다.")
        }
    }
}