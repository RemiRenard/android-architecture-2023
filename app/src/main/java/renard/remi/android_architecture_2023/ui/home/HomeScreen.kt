package renard.remi.android_architecture_2023.ui.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator?,
) {
    val context = LocalContext.current
    val viewModel = hiltViewModel<HomeViewModel>()
    val state = viewModel.state

    ConstraintLayout(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
    ) {

        val (title, input, result) = createRefs()

        Text(
            text = "Home Page",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .constrainAs(title) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top, 16.dp)
                }
        )

        TextField(
            modifier = Modifier
                .constrainAs(input) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(title.bottom, 16.dp)
                },
            value = state.textInput ?: "",
            onValueChange = { viewModel.onEvent(HomeFormEvent.UpdateTextInput(it)) },
            keyboardActions = KeyboardActions(
                onDone = {
                    viewModel.onEvent(HomeFormEvent.SubmitTextInput)
                }
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
        )

        Text(
            text = state.userGithub?.login ?: "No result",
            modifier = Modifier
                .constrainAs(result) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(input.bottom, 16.dp)
                }
        )
    }
}