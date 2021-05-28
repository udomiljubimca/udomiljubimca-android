package rs.udomiljubimca.ui.splash

import android.os.Bundle

import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import rs.udomiljubimca.ui.BaseActivity
import rs.udomiljubimca.R

@AndroidEntryPoint
class SplashActivity : BaseActivity() {
    private val viewModel by viewModels<SplashViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        viewModel.test()
    }
}