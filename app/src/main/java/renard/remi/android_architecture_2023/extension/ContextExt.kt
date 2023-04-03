package renard.remi.android_architecture_2023.extension

import android.content.Context
import androidx.datastore.dataStore
import renard.remi.android_architecture_2023.data.cache.AppSettingsSerializer

val Context.dataStore by dataStore("app-settings.json", AppSettingsSerializer)