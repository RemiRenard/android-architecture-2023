package renard.remi.android_architecture_2023.data.network

import renard.remi.android_architecture_2023.domain.model.UserGithub
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users/{username}")
    suspend fun getGithubUser(@Path("username") username: String): UserGithub
}