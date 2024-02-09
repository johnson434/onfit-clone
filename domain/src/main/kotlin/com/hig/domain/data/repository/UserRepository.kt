package com.hig.domain.data.repository

import com.hig.common.model.UserDto

interface UserRepository {
    fun signInWithPhone(phone: String)
    fun signInWithGoogle(email: String)
    fun signUpWithPhone(phone: String)
    fun signUpWithGoogle(email: String)
    fun getUserInfo(userNo: String): UserDto
    fun putUserInfo(userNo: String, userName: String, userPhotoUrl: String)
    fun patchUserInfo(userNo: String, userName: String, userPhotoUrl: String)
}