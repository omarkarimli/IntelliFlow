package com.omarkarimli.intelliflow.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.omarkarimli.intelliflow.data.source.local.Converters

@Entity
@TypeConverters(Converters::class)
data class NoteModel (
    @PrimaryKey(autoGenerate = true)
    val localId: Int? = null,

    val title: String? = null,
    val description: String? = null,
    val category: String? = null,
    val creationDate: String? = null,
    val editDate: String? = null,

    var isBookmarked: Boolean = false,
)