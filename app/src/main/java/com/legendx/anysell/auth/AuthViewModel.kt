package com.legendx.anysell.auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel: ViewModel() {
    private var _email = MutableStateFlow("")
    val email = _email.asStateFlow()
    private var _password = MutableStateFlow("")
    val password = _password.asStateFlow()
    private var _confirmPassword = MutableStateFlow("")
    val confirmPassword = _confirmPassword.asStateFlow()

    fun changeEmail(email: String){
        _email.value = email
    }
    fun changePassword(password: String) {
        _password.value = password
    }
    fun changeConfirmPassword(confirmPassword: String) {
        _confirmPassword.value = confirmPassword
    }



}