package com.example.testingprepopulateddb

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testingprepopulateddb.ui.theme.TestingPrePopulatedDBTheme

const val TAG = "!!!!!"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val app = applicationContext as App
        val repository = app.repository
        val vmFactory = ViewModelFactory(repository)
        setContent {
            TestingPrePopulatedDBTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GetData(
                        modifier = Modifier.padding(innerPadding),
                        viewModelFactory = vmFactory
                    )
                }
            }
        }
    }
}

@Composable
fun GetData(
    modifier: Modifier,
    viewModelFactory: ViewModelFactory
) {
    val viewModel: TestViewModel = viewModel(factory = viewModelFactory)
    val data by viewModel.state.collectAsState()
    Log.d(TAG, "GetData: $data")

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$data")
        Button(onClick = { viewModel.getData() }) {
            Text(text = "get data")
        }
    }
}