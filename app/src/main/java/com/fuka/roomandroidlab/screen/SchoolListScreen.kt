package com.fuka.roomandroidlab.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fuka.roomandroidlab.SchoolViewModel

@Composable
fun SchoolListScreen(schoolViewModel: SchoolViewModel, navController: NavController) {
    val schoolList = schoolViewModel.getAllSchools()?.observeAsState()

    if (schoolList?.value != null) {
        LazyColumn {
            items(schoolList?.value!!) { school ->
                Row {
                    Text("$school")

                    Spacer(Modifier.weight(1f))

                    Text(
                        text = "Students",
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable() {
                            navController.navigate("students/${school.id}")
                        })

                }
                Divider(modifier = Modifier.padding(bottom = 10.dp))
            }
        }
    }

}