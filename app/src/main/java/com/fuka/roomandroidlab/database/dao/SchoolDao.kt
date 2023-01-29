package com.fuka.roomandroidlab.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fuka.roomandroidlab.database.model.School

@Dao
interface SchoolDao {
    @Query("SELECT * FROM school")
    fun getAll(): LiveData<List<School>>

    @Query("SELECT * FROM school WHERE school.id = :school_id")
    fun getSchoolByID(school_id: Long): LiveData<School>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(school: School): Long

    @Update
    suspend fun update(school: School)

    @Delete
    suspend fun delete(school: School)
}