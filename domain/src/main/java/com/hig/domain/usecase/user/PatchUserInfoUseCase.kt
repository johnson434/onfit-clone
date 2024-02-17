package com.hig.domain.usecase.user

import com.hig.common.exception.UserValidationException
import com.hig.common.util.RegexUtil
import com.hig.domain.data.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

class PatchUserInfoUseCase(
    private val userRepository: UserRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend operator fun invoke(userNo: String, userName: String, userPhoto: File?): Result<Unit> = withContext(dispatcher) {
        runCatching {
            if (!RegexUtil.isValidUserName(userName)) {
                throw UserValidationException("유효하지 않은 유저명입니다.")
            }
            userRepository.patchUserInfo(userNo = userNo, userName = userName, userPhoto = userPhoto)
        }
    }
}