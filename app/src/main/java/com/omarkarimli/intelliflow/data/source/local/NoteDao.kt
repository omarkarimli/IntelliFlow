package com.omarkarimli.intelliflow.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.omarkarimli.intelliflow.domain.models.NoteModel

@Dao
interface NoteDao {

    @Query("SELECT * FROM notemodel")
    suspend fun getAll(): List<NoteModel>

    @Query("DELETE FROM notemodel")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(noteModel: NoteModel)

    @Query("SELECT * FROM notemodel WHERE localId = :noteId")
    suspend fun getNoteById(noteId: Int): NoteModel?

    @Insert(onConflict = OnConflictStrategy.NONE)
    suspend fun addNote(noteModel: NoteModel)

    @Update
    suspend fun updateNote(noteModel: NoteModel)
}