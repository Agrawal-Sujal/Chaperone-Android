package com.sunflower.chaperone.ui.screens.onboarding.signin

data class SignInUiState(
    val email: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false,
    val isLoading: Boolean = false
)