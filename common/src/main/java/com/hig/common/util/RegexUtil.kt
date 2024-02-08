package com.hig.common.util

object RegexUtil {
    fun isValidPhoneNumber(phone: String): Boolean {
        val phonePattern = Regex("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}\$")
        return phonePattern.matches(phone)
    }

    fun isValidEmail(email: String): Boolean {
        val emailPattern = Regex("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$")
        return emailPattern.matches(email)
    }
}