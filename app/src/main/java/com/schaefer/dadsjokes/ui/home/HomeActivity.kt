package com.schaefer.dadsjokes.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.schaefer.dadsjokes.ui.theme.DadsJokesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeViewModel.getRandomJoke()

        setContent {
            DadsJokesTheme {
                Scaffold(floatingActionButton =
                {
                    FloatingActionButton(onClick = {
                        homeViewModel.getRandomJoke()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Refresh,
                            contentDescription = "Refresh Joke",
                            tint = Color.White
                        )
                    }
                }) {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.primary
                    ) {
                        JokeContent(homeViewModel.uiState)
                    }
                }
            }
        }
    }
}

@Composable
internal fun JokeContent(homeState: HomeState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (homeState.loading) {
            CircularProgressIndicator(color = Color.White)
        } else {
            Text(
                text = homeState.joke?.joke.orEmpty(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5
            )
        }
    }
}