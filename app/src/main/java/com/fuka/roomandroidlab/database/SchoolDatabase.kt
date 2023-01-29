package com.fuka.roomandroidlab.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fuka.roomandroidlab.database.dao.SchoolDao
import com.fuka.roomandroidlab.database.dao.StudentDao
import com.fuka.roomandroidlab.database.model.School
import com.fuka.roomandroidlab.database.model.Student


@Database(entities = [School::class, Student::class], version = 1)
abstract class SchoolDatabase : RoomDatabase() {
    abstract fun schoolDao(): SchoolDao
    abstract fun studentDao(): StudentDao

    companion object Instance {
        private var instance: SchoolDatabase? = null

        @Synchronized
        fun get(context: Context): SchoolDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    SchoolDatabase::class.java, "SchoolDatabase"
                ).build()
            }
            return instance
        }
    }
}