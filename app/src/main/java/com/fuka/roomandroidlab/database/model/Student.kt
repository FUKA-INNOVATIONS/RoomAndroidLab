package com.fuka.roomandroidlab.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @ColumnInfo(name = "school") val school: Long,
    @PrimaryKey(autoGenerate = true) val student_id: Long,
    @ColumnInfo(name = "first_name") val first_name: String,
    @ColumnInfo(name = "last_name") val last_name: String,
){
    override fun toString(): String {
        return "$first_name $last_name"
    }
}
