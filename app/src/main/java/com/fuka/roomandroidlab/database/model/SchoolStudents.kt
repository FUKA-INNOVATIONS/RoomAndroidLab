package com.fuka.roomandroidlab.database.model

import androidx.room.Embedded
import androidx.room.Relation

class SchoolStudents {
    @Embedded
    var school: School? = null
    @Relation(parentColumn = "id", entityColumn = "school")
    var students : List<Student>? = null
}