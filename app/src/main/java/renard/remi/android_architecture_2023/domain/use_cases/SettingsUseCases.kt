package renard.remi.android_architecture_2023.domain.use_cases

import android.content.Context
import renard.remi.android_architecture_2023.extension.dataStore

data class SettingsUseCases(
    val context: Context
) {

    fun loadSettings() = context.dataStore.data

    suspend fun updateDynamicColors(enabled: Boolean) {
        context.dataStore.updateData {
            it.copy(useDynamicColors = enabled)
        }
    }
}