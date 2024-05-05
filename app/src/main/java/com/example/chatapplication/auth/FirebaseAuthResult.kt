package com.example.chatapplication.auth

import com.google.firebase.auth.FirebaseUser

sealed class FirebaseAuthResult {
    object Loading : FirebaseAuthResult()
    data class Success(val user: FirebaseUser?) : FirebaseAuthResult()
    data class Failure(val error: Throwable) : FirebaseAuthResult()
}