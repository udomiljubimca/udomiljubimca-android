package rs.udomiljubimca.ui.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import rs.udomiljubimca.managers.PreferencesManager
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {

    @Inject
    lateinit var preferencesManager: PreferencesManager
    fun test() {
        val tokIn = "toktok"
        preferencesManager.saveToken(tokIn)
        val tokOut = preferencesManager.getToken()
        Timber.i("Token test: $tokIn - $tokOut ${tokIn == tokOut}")
    }
}