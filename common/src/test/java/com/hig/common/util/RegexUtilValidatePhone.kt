package com.hig.common.util

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RegexUtilValidatePhone {
    @Test
    fun `전화 번호 입력이 없을 때, False를 반환`() {
        assertFalse(RegexUtil.isValidPhoneNumber(""))
    }

    @Test
    fun `-(하이픈)이 없을 때, False를 반환`() {
        assertFalse(RegexUtil.isValidPhoneNumber("01012345678"))
    }

    @Test
    fun `정상적인 입력이 들어왔을 때, True를 반환`() {
        assertTrue(RegexUtil.isValidPhoneNumber("010-123-5678"))
        assertTrue(RegexUtil.isValidPhoneNumber("010-1234-5678"))
        assertTrue(RegexUtil.isValidPhoneNumber("011-123-5678"))
        assertTrue(RegexUtil.isValidPhoneNumber("011-1234-5678"))
    }
}