package com.hig.domain.usecase

import com.hig.common.util.RegexUtil
import com.hig.common.exception.UserValidationException
import com.hig.domain.data.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SignInWithPhoneUseCase(
    private val userRepository: UserRepository,
    private val dispatchers: CoroutineDispatcher = Dispatchers.Default
) {
    suspend operator fun invoke(phoneNumber: String): Result<Unit> = withContext(dispatchers) {
        runCatching {
            if (!RegexUtil.isValidPhoneNumber(phone = phoneNumber)) {
                throw UserValidationException("유효하지 않은 전화번호입니다.")
            }
            userRepository.signInWithPhone(phone = phoneNumber)
        }
    }
}