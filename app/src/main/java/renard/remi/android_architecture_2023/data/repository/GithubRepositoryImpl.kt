package renard.remi.android_architecture_2023.data.repository

import renard.remi.android_architecture_2023.data.network.ApiService
import renard.remi.android_architecture_2023.domain.model.UserGithub
import renard.remi.android_architecture_2023.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : GithubRepository {

    override suspend fun getGithubUser(username: String?): UserGithub? {
        return if (username.isNullOrEmpty()) {
            null
        } else {
            apiService.getGithubUser(username)
        }
    }
}