package com.omarkarimli.intelliflow.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.omarkarimli.intelliflow.domain.models.NoteModel

@Database(
    entities = [NoteModel::class],
    version = 1,
    exportSchema = false
)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}