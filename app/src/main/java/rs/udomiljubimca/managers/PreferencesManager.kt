package rs.udomiljubimca.managers

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesManager @Inject constructor(@ApplicationContext val context: Context) {
    private val preferencesFile = "prefs"
    private val preferences = context.getSharedPreferences(preferencesFile, Context.MODE_PRIVATE)
    private val kToken = "key_token"


    fun saveToken(token: String) {
        preferences.edit().putString(kToken, token).apply()
    }
    fun getToken(): String {
        return preferences.getString(kToken, "") ?: ""
    }
}