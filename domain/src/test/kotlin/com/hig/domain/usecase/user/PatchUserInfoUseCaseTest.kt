package com.hig.domain.usecase.user

import com.hig.common.exception.UserValidationException
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class PatchUserInfoUseCaseTest {
    @Test
    fun `사용자가 사진을 넣지 않았을 때, 정상적으로 실행`() {
        val patchUserInfoUseCase = PatchUserInfoUseCase(mockk(relaxed = true))
        val userNo = "1234"
        val userName = "username"

        runTest {
            assertTrue {
                patchUserInfoUseCase(userNo = userNo, userName = userName, userPhoto = null).isSuccess
            }
        }
    }

    @Test
    fun `사용자의 이름이 유효한 이름이 아니면, UserValidationException을 던짐`() {
        val patchUserInfoUseCase = PatchUserInfoUseCase(mockk(relaxed = true))
        val userNo = "1234"
        val userNames = listOf(
            "",
            " ",
            "  ",
            "   ",
            "",
            "1",
            "가",
            "ㄱ",
            "a"
        )

        runTest {
            userNames.forEach { name ->
                assertFailsWith(UserValidationException::class) {
                    patchUserInfoUseCase(userNo = userNo, userName = name, userPhoto = null).getOrThrow()
                }
            }
        }
    }
}