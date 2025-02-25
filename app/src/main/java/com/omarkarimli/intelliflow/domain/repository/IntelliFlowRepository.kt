package com.omarkarimli.intelliflow.domain.repository

import com.google.firebase.firestore.DocumentSnapshot
import com.omarkarimli.intelliflow.domain.models.NoteModel

interface IntelliFlowRepository {

    suspend fun changePassword(email: String, currentPassword: String, newPassword: String)

    suspend fun fetchUserData(): DocumentSnapshot

    suspend fun fetchNotes(): List<NoteModel>

    suspend fun getAllNotesFromLocal(): List<NoteModel>

    suspend fun deleteNoteFromLocal(noteModel: NoteModel)

    suspend fun getNoteByIdFromLocal(noteId: Int): NoteModel?

    suspend fun addNoteToLocal(noteModel: NoteModel)

    suspend fun updateNoteLocally(noteModel: NoteModel)

    suspend fun deleteAllNotesFromLocal()
}