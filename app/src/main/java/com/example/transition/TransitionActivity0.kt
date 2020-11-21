package com.example.transition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionInflater

class TransitionActivity0 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition0)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            window.enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.activity_transition0_enter)
            window.returnTransition = TransitionInflater.from(this).inflateTransition(R.transition.activity_transition0_out)
        }
    }
}