package rs.udomiljubimca

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import rs.udomiljubimca.managers.PreferencesManager
import javax.inject.Inject

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class PreferencesMangerInstrumentedTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)
    @Inject
    lateinit var preferencesManager: PreferencesManager
    @Before
    fun init() {
        hiltRule.inject()
    }

//    @Test
//    fun useAppContext() {
//        // Context of the app under test.
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
//        assertEquals("rs.udomiljubimca", appContext.packageName)
//    }

    @Test
    fun token_ok() {
        val tokenTo = "xxx123yyy456"
        preferencesManager.saveToken(tokenTo)
        val tokenFrom = preferencesManager.getToken()
        assertEquals(tokenTo, tokenFrom)
    }
}