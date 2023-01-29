package com.fuka.roomandroidlab.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class School(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "name") val name: String
) {
    override fun toString(): String = "$id $name"
}
