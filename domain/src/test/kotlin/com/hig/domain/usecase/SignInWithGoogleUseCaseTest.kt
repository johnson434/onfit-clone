package com.hig.domain.usecase

import com.hig.common.exception.UserValidationException
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class SignInWithGoogleUseCaseTest {
    @Test
    fun `유효한 이메일이 들어왔을 때, 에러를 던지지 않음`() {
        val signInWithGoogleUseCase = SignInWithGoogleUseCase(mockk(relaxed = true))
        val emailList = """
            john@example.com
            mary.smith@example.co.uk
            bob123@example.org
            alice+johnson@example.net
            john.doe@example.com
            jane_doe123@example.com
            test_email@example.io
            info@example.com
            support@example.org
            sales@example.net
        """.trimIndent().split("\n")

        runTest {
            emailList.forEach {email ->
                assertTrue(message = "email : $email", actual = signInWithGoogleUseCase(email).isSuccess)
            }
        }
    }

    @Test
    fun `유효하지 않은 이메일이 들어왔을 때, False를 리턴`() {
        val emailList = """
            john@example
            mary.smith@example.
            bob123@example
            alice+johnson@example
            john.doe@example
            jane_doe123@example
            test_email@example
            info@
            support@example.
            sales@example
        """.trimIndent().split("\n")
        val signInWithGoogleUseCase = SignInWithGoogleUseCase(mockk())

        runTest {
            emailList.forEach { email ->
                assertFailsWith(UserValidationException::class) {
                    signInWithGoogleUseCase(email).getOrThrow()
                }
            }
        }
    }
}