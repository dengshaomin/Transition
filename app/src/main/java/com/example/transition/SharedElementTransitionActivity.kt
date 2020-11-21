package com.example.transition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionInflater

class SharedElementTransitionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_element_transition)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            window.enterTransition =TransitionInflater.from(this).inflateTransition(R.transition.activity_transition0_enter)
            window.exitTransition = TransitionInflater.from(this).inflateTransition(R.transition.activity_transition0_out)
            window.sharedElementEnterTransition =TransitionInflater.from(this).inflateTransition(R.transition.activity_share_transition_enter)
            window.sharedElementReturnTransition = TransitionInflater.from(this).inflateTransition(R.transition.activity_share_transition_enter)
        }
    }
}