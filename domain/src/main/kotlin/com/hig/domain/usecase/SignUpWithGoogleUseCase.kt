package com.hig.domain.usecase

import com.hig.common.exception.UserValidationException
import com.hig.common.util.RegexUtil
import com.hig.domain.data.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SignUpWithGoogleUseCase(
    private val userRepository: UserRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend operator fun invoke(email: String): Result<Unit> = withContext(dispatcher) {
        runCatching {
            if (!RegexUtil.isValidEmail(email = email)) {
                throw UserValidationException("유효하지 않은 이메일입니다.")
            }
            userRepository.signUpWithGoogle(email = email)
        }
    }
}