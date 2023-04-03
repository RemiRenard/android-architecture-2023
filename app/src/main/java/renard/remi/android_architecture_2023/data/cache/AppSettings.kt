package renard.remi.android_architecture_2023.data.cache

import kotlinx.serialization.Serializable

@Serializable
data class AppSettings(
    val useDynamicColors: Boolean = false
)