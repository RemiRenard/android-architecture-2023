package renard.remi.android_architecture_2023.domain.use_cases

import android.content.Context
import renard.remi.android_architecture_2023.domain.repository.GithubRepository

data class HomeUseCases(
    val context: Context,
    val githubRepository: GithubRepository
) {

    suspend fun getGithubUser(username: String) {
        githubRepository.getGithubUser(username)
    }
}