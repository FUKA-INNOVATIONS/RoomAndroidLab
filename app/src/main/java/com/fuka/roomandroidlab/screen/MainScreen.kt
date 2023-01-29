package com.fuka.roomandroidlab.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fuka.roomandroidlab.SchoolViewModel

@Composable
fun MainScreen(schoolViewModel: SchoolViewModel, navController: NavController) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(text = "hello from main screen")
        CreateSchool(schoolViewModel = schoolViewModel)

        SchoolListScreen(schoolViewModel, navController)
    }
}