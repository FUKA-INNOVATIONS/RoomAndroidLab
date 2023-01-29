package com.fuka.roomandroidlab.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import com.fuka.roomandroidlab.SchoolViewModel

@Composable
fun StudentListScreen(schoolViewModel: SchoolViewModel, schoolId: Long, navController: NavController) {
    val selectedSchool = schoolViewModel.getSchoolById(schoolId)?.observeAsState()
    val studentList = schoolViewModel.getStudentsBySchoolId(schoolId).observeAsState()

    Column {
        Text(text = selectedSchool?.value?.name.toString() + " students")
        Divider(modifier = Modifier.padding(bottom = 10.dp))

        // Display a list of students of selected school
        if (studentList.value != null) {
            LazyColumn(
                modifier = Modifier.padding(bottom = 15.dp),
                content = {
                items(studentList.value!!) { student ->
                    Row() {
                        Text(text = "$student")
                        Spacer(Modifier.weight(1f))
                        Text(
                            text = "delete",
                            color = Color.Red,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.clickable() {
                                schoolViewModel.deleteStudent(student)
                            })

                    }
                    Divider(modifier = Modifier.padding(bottom = 5.dp))
                }
            })
        }

        // Add new student
        CreateStudent(schoolViewModel, id = schoolId)
    }
}