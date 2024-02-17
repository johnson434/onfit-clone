package com.hig.domain.data.repository.user

import com.hig.common.model.UserDto
import java.io.File

interface UserRepository {
    fun signInWithPhone(phone: String)
    fun signInWithGoogle(email: String)
    fun signUpWithPhone(phone: String)
    fun signUpWithGoogle(email: String)
    fun getUserInfo(userNo: String): UserDto?
    fun putUserInfo(userNo: String, userName: String, userPhoto: File?)
    fun patchUserInfo(userNo: String, userName: String, userPhoto: File?)
}