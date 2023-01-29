package com.fuka.roomandroidlab.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fuka.roomandroidlab.SchoolViewModel
import com.fuka.roomandroidlab.database.model.School

@Composable
fun CreateSchool(schoolViewModel: SchoolViewModel) {
    var schoolName by remember { mutableStateOf("") }

    Row {
        TextField(
            modifier = Modifier.width(200.dp),
            value = schoolName,
            placeholder = {
                Text(text = "School Name")
            },
            onValueChange = { schoolName = it })

        Button(onClick = {
            if (schoolName.isNotEmpty()) {
                schoolViewModel.insertSchool(School(0, schoolName))
            }
        }) {
            Text(text = "Add")
        }
    }

}