package com.fuka.roomandroidlab

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.fuka.roomandroidlab.database.SchoolDatabase
import com.fuka.roomandroidlab.database.model.School
import com.fuka.roomandroidlab.database.model.Student
import kotlinx.coroutines.launch

class SchoolViewModel(application: Application) : AndroidViewModel(application) {
    private val schoolDatabase: SchoolDatabase? = SchoolDatabase.get(application)

    fun getAllSchools(): LiveData<List<School>>? = schoolDatabase?.schoolDao()?.getAll()

    fun getSchoolById(schoolId: Long) : LiveData<School>? = schoolDatabase?.schoolDao()?.getSchoolByID(schoolId)

    fun getStudentsBySchoolId(schoolId: Long): LiveData<List<Student>> {
        return schoolDatabase?.studentDao()!!.getStudentsBySchoolID(schoolId)
    }

    fun insertSchool(school: School){
        viewModelScope.launch {
            schoolDatabase?.schoolDao()?.insert(school)
        }
    }

    fun insertStudent(student: Student){
        viewModelScope.launch {
            schoolDatabase?.studentDao()?.insert(student)
        }
    }

    fun deleteStudent(student: Student) {
        viewModelScope.launch {
            schoolDatabase?.studentDao()!!.delete(student)
        }
    }

}