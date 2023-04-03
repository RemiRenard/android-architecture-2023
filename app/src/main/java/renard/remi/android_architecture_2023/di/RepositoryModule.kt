package renard.remi.android_architecture_2023.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import renard.remi.android_architecture_2023.data.repository.GithubRepositoryImpl
import renard.remi.android_architecture_2023.domain.repository.GithubRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindGithubRepository(
        githubRepository: GithubRepositoryImpl,
    ): GithubRepository
}