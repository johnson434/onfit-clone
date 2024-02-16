package com.hig.domain.usecase

import com.hig.common.exception.UserNotFoundException
import com.hig.domain.data.repository.UserRepository
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertFailsWith

class GetUserInfoUseCaseTest {
    @Test
    fun `UserRepository에서 Null을 리턴할 때, UserNotFoundException을 던짐`() {
        val userRepository = mockk<UserRepository>()
        every { userRepository.getUserInfo(any()) } returns null

        val getUserInfoUseCase = GetUserInfoUseCase(userRepository = userRepository)
        runTest {
            assertFailsWith(UserNotFoundException::class) {
                getUserInfoUseCase("1").getOrThrow()
            }
        }
    }
}