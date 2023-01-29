package com.fuka.roomandroidlab

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fuka.roomandroidlab.screen.MainScreen
import com.fuka.roomandroidlab.screen.StudentListScreen

@Composable
fun AppNavigation(schoolViewModel: SchoolViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(schoolViewModel, navController)
        }

        composable("students/{school_id}") {
            val schoolId = it.arguments?.getString("school_id")?.toLong() ?: 0
            StudentListScreen(schoolViewModel, schoolId, navController)
        }
    }

}