package renard.remi.android_architecture_2023.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import renard.remi.android_architecture_2023.domain.repository.GithubRepository
import renard.remi.android_architecture_2023.domain.use_cases.HomeUseCases
import renard.remi.android_architecture_2023.domain.use_cases.SettingsUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideHomeUseCases(
        @ApplicationContext appContext: Context,
        githubRepository: GithubRepository
    ): HomeUseCases {
        return HomeUseCases(
            context = appContext,
            githubRepository = githubRepository
        )
    }

    @Provides
    @Singleton
    fun provideSettingsUseCases(
        @ApplicationContext appContext: Context,
    ): SettingsUseCases {
        return SettingsUseCases(
            context = appContext,
        )
    }
}