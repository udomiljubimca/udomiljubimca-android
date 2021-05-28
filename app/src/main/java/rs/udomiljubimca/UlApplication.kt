package rs.udomiljubimca

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import rs.udomiljubimca.managers.PreferencesManager
import timber.log.Timber
import timber.log.Timber.DebugTree
import javax.inject.Inject


@HiltAndroidApp
class UlApplication : Application() {

    @Inject
    lateinit var preferencesManager: PreferencesManager

    override fun onCreate() {
        super.onCreate()
        // Init Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}