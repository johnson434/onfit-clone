package com.hig.common.util

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RegexUtilValidateUserName {
    @Test
    fun `이름이 한글, 영어, 숫자로 이루어진 2글자 이상 10글자 이하일 때, True를 리턴`() {
        val testCases = listOf(
            "ㄱㄴ",
            "가가",
            "힣힣",
            "aa",
            "zz",
            "00",
            "99",
            "가a",
            "a가",
            "가1",
            "1가",
            "a1",
            "1a"
        )

        testCases.forEach { name ->
            assertTrue("name : $name", RegexUtil.isValidUserName(name))
        }
    }

    @Test
    fun `이름이 공백일 때, False를 리턴`() {
        val testCases = listOf(
            "",
            " ",
            "  ",
            "   "
        )

        testCases.forEach {name ->
            assertFalse("name : $name",RegexUtil.isValidUserName(userName = name))
        }
    }

    @Test
    fun `이름이 1글자 이하일 때, False를 리턴`() {
        val testCases = listOf(
            "",
            "1",
            "가",
            "ㄱ",
            "a"
        )

        testCases.forEach { name ->
            assertFalse("name : $name", RegexUtil.isValidUserName(userName = name))
        }
    }

    @Test
    fun `이름에 특수문자가 들어갔을 때, False를 리턴`() {
        val testCases = listOf(
            "마!",
            "!!",
            "@@",
            "비상!@"
        )

        testCases.forEach { name ->
            assertFalse("name : $name", RegexUtil.isValidUserName(name))
        }
    }
}