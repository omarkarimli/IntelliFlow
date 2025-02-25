package com.omarkarimli.intelliflow.data.source.local

import com.omarkarimli.intelliflow.domain.models.NoteModel
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val noteDao: NoteDao
) : LocalDataSource {

    override suspend fun getAllLocally() = noteDao.getAll()

    override suspend fun deleteNoteLocally(noteModel: NoteModel) = noteDao.delete(noteModel)

    override suspend fun getNoteByIdLocally(noteId: Int) = noteDao.getNoteById(noteId)

    override suspend fun addNoteLocally(noteModel: NoteModel) = noteDao.addNote(noteModel)

    override suspend fun updateNoteLocally(noteModel: NoteModel) = noteDao.updateNote(noteModel)

    override suspend fun deleteAllLocally() = noteDao.deleteAll()
}