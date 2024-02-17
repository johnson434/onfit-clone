package com.hig.domain.usecase.user

import com.hig.common.exception.UserValidationException
import com.hig.common.util.RegexUtil
import com.hig.domain.data.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SignUpWithPhoneUseCase(
    private val userRepository: UserRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend operator fun invoke(phone: String): Result<Unit> = withContext(dispatcher) {
        runCatching {
            if (!RegexUtil.isValidPhoneNumber(phone = phone)) {
                throw UserValidationException("유효하지 않은 전화번호입니다.")
            }
            userRepository.signUpWithPhone(phone = phone)
        }
    }
}