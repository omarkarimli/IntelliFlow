package com.omarkarimli.intelliflow.data.source.remote

import com.google.firebase.auth.AuthResult
import com.google.firebase.firestore.DocumentSnapshot
import com.omarkarimli.intelliflow.domain.models.NoteModel
import java.io.Serializable

interface RemoteDataSource {

    suspend fun changePassword(email: String, currentPassword: String, newPassword: String)

    suspend fun fetchUserData(): DocumentSnapshot

    suspend fun loginUserAccount(isChecked: Boolean, email: String, password: String): AuthResult

    suspend fun registerNewUser(email: String, password: String): AuthResult

    suspend fun addUserToFirestore(userData: HashMap<String, Serializable>)
}