package rs.udomiljubimca.main

import android.os.Bundle
import rs.udomiljubimca.BaseActivity
import rs.udomiljubimca.R

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}