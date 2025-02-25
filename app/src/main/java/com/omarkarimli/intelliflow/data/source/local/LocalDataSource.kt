package com.omarkarimli.intelliflow.data.source.local

import com.omarkarimli.intelliflow.domain.models.NoteModel

interface LocalDataSource {

    suspend fun getAllLocally(): List<NoteModel>

    suspend fun deleteNoteLocally(noteModel: NoteModel)

    suspend fun getNoteByIdLocally(noteId: Int): NoteModel?

    suspend fun addNoteLocally(noteModel: NoteModel)

    suspend fun updateNoteLocally(noteModel: NoteModel)

    suspend fun deleteAllLocally()
}