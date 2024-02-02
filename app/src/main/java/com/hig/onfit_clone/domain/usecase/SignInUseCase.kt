package com.hig.onfit_clone.domain.usecase

import com.hig.onfit_clone.ui.viewmodel.SignInMethod

class SignInUsecase {
    operator fun invoke(signInMethod: SignInMethod, vararg args: String) {
        when (signInMethod) {
            SignInMethod.Email -> {
                val email = args[0]
            }

            SignInMethod.Google -> {
                val google = args[0]
            }

            SignInMethod.Phone -> {
                val phone = args[0]
            }
        }
    }

}