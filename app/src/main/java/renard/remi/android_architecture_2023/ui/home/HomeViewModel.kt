package renard.remi.android_architecture_2023.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import renard.remi.android_architecture_2023.domain.model.UserGithub
import renard.remi.android_architecture_2023.domain.use_cases.HomeUseCases
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeUseCases: HomeUseCases) : ViewModel() {

    var state by mutableStateOf(HomeState())

    fun onEvent(event: HomeFormEvent) {
        when (event) {
            is HomeFormEvent.UpdateTextInput -> {
                state = state.copy(textInput = event.txt)
            }
            is HomeFormEvent.SubmitTextInput -> {
                viewModelScope.launch {
                    val userGithub =
                        homeUseCases.githubRepository.getGithubUser(state.textInput)
                    state = state.copy(userGithub = userGithub)
                }
            }
        }
    }
}

sealed class HomeFormEvent {
    data class UpdateTextInput(val txt: String) : HomeFormEvent()
    object SubmitTextInput : HomeFormEvent()
}

data class HomeState(
    val textInput: String? = null,
    val userGithub: UserGithub? = null,
)