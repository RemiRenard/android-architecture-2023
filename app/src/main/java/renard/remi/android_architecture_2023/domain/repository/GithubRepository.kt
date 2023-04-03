package renard.remi.android_architecture_2023.domain.repository

import renard.remi.android_architecture_2023.domain.model.UserGithub

interface GithubRepository {

    suspend fun getGithubUser(username: String?): UserGithub?
}