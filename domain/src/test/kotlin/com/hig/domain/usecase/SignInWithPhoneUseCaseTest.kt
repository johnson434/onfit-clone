package com.hig.domain.usecase

import com.hig.common.exception.UserValidationException
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertFailsWith

class SignInWithPhoneUseCaseTest {
    @Test
    fun `유효한 휴대폰 번호를 입력했을 때, 에러를 던지지 않음`() {
        val signInWithPhoneUseCase = SignInWithPhoneUseCase(mockk())
        val phoneNums = """
            010-123-5678
            010-1234-5678
            011-123-5678
            011-1234-5678
        """.trimIndent().split("\n")

        runTest {
            phoneNums.forEach { phoneNumber ->
                signInWithPhoneUseCase(phoneNumber = phoneNumber)
            }
        }
    }

    @Test
    fun `유효하지 않은 휴대폰 번호를 입력했을 때, UserValidationException을 던짐`() {
        val signInWithPhoneUseCase = SignInWithPhoneUseCase(mockk())
        val phoneNums = """
            0101234567
            012-1234-5678
            013-1234-5678
            014-1234-5678
            015-1234-5678
            010-1234-567
            010-1234-56789
            010-12A4-5678
            010-123-45678
        """.trimIndent().split("\n")

        runTest {
            phoneNums.forEach {  phoneNumber ->
                assertFailsWith(UserValidationException::class) {
                    signInWithPhoneUseCase(phoneNumber = phoneNumber).getOrThrow()
                }
            }
        }
    }
}