package com.omarkarimli.intelliflow.data.repository

import com.omarkarimli.intelliflow.data.source.local.LocalDataSource
import com.omarkarimli.intelliflow.data.source.remote.RemoteDataSource
import com.omarkarimli.intelliflow.domain.models.NoteModel
import com.omarkarimli.intelliflow.domain.repository.IntelliFlowRepository
import javax.inject.Inject

class IntelliFlowRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : IntelliFlowRepository {

    // Remote
    override suspend fun changePassword(email: String, currentPassword: String, newPassword: String) = remoteDataSource.changePassword(email, currentPassword, newPassword)

    override suspend fun fetchUserData() = remoteDataSource.fetchUserData()

    // Local
    override suspend fun fetchNotes() = localDataSource.getAllLocally()

    override suspend fun getAllNotesFromLocal() = localDataSource.getAllLocally()

    override suspend fun deleteNoteFromLocal(noteModel: NoteModel) = localDataSource.deleteNoteLocally(noteModel)

    override suspend fun getNoteByIdFromLocal(noteId: Int) = localDataSource.getNoteByIdLocally(noteId)

    override suspend fun addNoteToLocal(noteModel: NoteModel) = localDataSource.addNoteLocally(noteModel)

    override suspend fun updateNoteLocally(noteModel: NoteModel) = localDataSource.updateNoteLocally(noteModel)

    override suspend fun deleteAllNotesFromLocal() = localDataSource.deleteAllLocally()
}