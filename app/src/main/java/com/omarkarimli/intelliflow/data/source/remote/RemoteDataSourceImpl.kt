package com.omarkarimli.intelliflow.data.source.remote

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.omarkarimli.myecommerceapp.utils.Constants
import kotlinx.coroutines.tasks.await
import java.io.Serializable
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val provideAuth: FirebaseAuth,
    private val provideFirestore: FirebaseFirestore,
) : RemoteDataSource {

    override suspend fun changePassword(email: String, currentPassword: String, newPassword: String) {
        val user = provideAuth.currentUser ?: FirebaseAuth.getInstance().currentUser
        val credential = EmailAuthProvider.getCredential(email, currentPassword)

        try {
            if (user != null) {
                user.reauthenticate(credential).await() // Re-authenticate user
                user.updatePassword(newPassword).await() // Update password
            } else {
                throw Exception("User is not authenticated")
            }
        } catch (e: Exception) {
            throw e // Handle exception appropriately
        }
    }

    override suspend fun fetchUserData(): DocumentSnapshot =
        provideFirestore
            .collection(Constants.USERS)
            .document(provideAuth.currentUser?.uid ?: "error")
            .get()
            .await()

    override suspend fun loginUserAccount(isChecked: Boolean, email: String, password: String): AuthResult =
        provideAuth
            .signInWithEmailAndPassword(email, password)
            .await()

    override suspend fun registerNewUser(email: String, password: String): AuthResult =
        provideAuth
            .createUserWithEmailAndPassword(email, password)
            .await()

    override suspend fun addUserToFirestore(userData: HashMap<String, Serializable>) {
        val uid = provideAuth.currentUser?.uid ?: "error"
        provideFirestore
            .collection(Constants.USERS)
            .document(uid)
            .set(userData)
            .await()
    }
}