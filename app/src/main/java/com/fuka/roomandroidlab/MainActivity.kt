package com.fuka.roomandroidlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fuka.roomandroidlab.screen.StudentListScreen
import com.fuka.roomandroidlab.ui.theme.RoomAndroidLabTheme

class MainActivity : ComponentActivity() {
    private lateinit var schoolViewModel: SchoolViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        schoolViewModel = SchoolViewModel(application)

        setContent {

            RoomAndroidLabTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation(schoolViewModel)
                }
            }
        }
    }
}
