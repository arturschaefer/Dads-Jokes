package com.schaefer.dadsjokes.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.schaefer.dadsjokes.domain.DadsJokesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val dadsJokesRepository: DadsJokesRepository
) : ViewModel() {

    var uiState by mutableStateOf(HomeState())
        private set

    fun getRandomJoke() {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                uiState = uiState.copy(loading = true)
            }

            val result = dadsJokesRepository.getRandomJoke()

            withContext(Dispatchers.Main) {
                if (result?.joke != null){
                    uiState = uiState.copy(joke = result, loading = false)
                }
            }
        }
    }
}