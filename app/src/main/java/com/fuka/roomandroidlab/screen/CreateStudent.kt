package com.fuka.roomandroidlab.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fuka.roomandroidlab.SchoolViewModel
import com.fuka.roomandroidlab.database.model.Student


@Composable
fun CreateStudent(schoolViewModel: SchoolViewModel, id: Long) {
    var studentFirstName by remember { mutableStateOf("") }
    var studentLastName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        TextField(
            value = studentFirstName,
            placeholder = {
                Text(text = "First name")
            },
            onValueChange = {
                studentFirstName = it
            })

        TextField(
            value = studentLastName,
            placeholder = { Text(text = "Last name") },
            onValueChange = { studentLastName = it })

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            try {
                if (studentFirstName.isNotEmpty() && studentLastName.isNotEmpty()) {
                    schoolViewModel.insertStudent(
                        Student(id, 0, studentFirstName, studentLastName,)
                    )
                }
            } catch (e: java.lang.Exception) {
                Log.d("ROOMLABFUKA", "error adding new student $e")
            }
        }) {
            Text(text = "Add student")
        }
    }
}
