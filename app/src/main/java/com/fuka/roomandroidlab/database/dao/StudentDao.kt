package com.fuka.roomandroidlab.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.fuka.roomandroidlab.database.model.School
import com.fuka.roomandroidlab.database.model.Student

@Dao
interface StudentDao {
    @Query("SELECT * FROM student")
    fun getAll(): LiveData<List<Student>>

    @Query("SELECT * FROM student WHERE school = :school_id")
    fun getStudentsBySchoolID(school_id: Long): LiveData<List<Student>>

    @Insert
    suspend fun insert(student: Student) : Long

    @Delete
    suspend fun delete(student: Student)
}