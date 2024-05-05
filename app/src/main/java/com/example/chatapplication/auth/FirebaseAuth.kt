package com.example.chatapplication.auth

import android.util.Log
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
suspend fun FirebaseAuth.createUserWithEmailAndPasword(email: String, password: String): AuthResult {
    return try {
        this.createUserWithEmailAndPassword(email, password).await()
    } catch (e: Exception) {
        throw CancellationException("Authentication failed.", e)
    }
}


fun createUser(email: String, password: String): Flow<FirebaseAuthResult> = flow {
    val auth = FirebaseAuth.getInstance()
    emit(FirebaseAuthResult.Loading) // Emit loading state to the flow
    try {
        val result = auth.createUserWithEmailAndPasword(email, password) // This should be your suspend function call
        emit(FirebaseAuthResult.Success(result.user)) // Emit success state with user
    } catch (e: Exception) {
        emit(FirebaseAuthResult.Failure(e)) // Emit failure state with error
        Log.e("RegisterError", "Failed to register user", e)
    }
}
