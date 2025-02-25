package com.omarkarimli.intelliflow.di

import android.content.Context
import androidx.room.Room
import com.omarkarimli.intelliflow.data.source.local.NoteDao
import com.omarkarimli.intelliflow.data.source.local.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDbModule {

    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(context, NoteDatabase::class.java, "noteDB").build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(noteDatabase: NoteDatabase): NoteDao {
        return noteDatabase.noteDao()
    }
}