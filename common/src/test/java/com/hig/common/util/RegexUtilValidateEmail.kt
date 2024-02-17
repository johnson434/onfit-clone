package com.hig.common.util

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RegexUtilValidateEmail {
    @Test
    fun `유효한 이메일이 들어왔을 때, True를 리턴`() {
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
        """.trimIndent()

        emailList.split("\n").forEach { email -> assertTrue("email : $email", RegexUtil.isValidEmail(email = email)) }
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
        """.trimIndent()

        emailList.split("\n").forEach { email -> assertFalse("email : $email", RegexUtil.isValidEmail(email)) }
    }
}