package com.example.transition

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.transition.Explode
import android.transition.TransitionInflater
import android.view.View
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        go.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    TransitionManagerGoActivity::class.java
                )
            )
        }
        beginDelayedTransition.setOnClickListener {
            startActivity(Intent(this, BeginDelayedTransitionActivity::class.java))
        }

        transition0.setOnClickListener {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                window.enterTransition = Explode()
                window.exitTransition = Explode()
                startActivity(
                    Intent(this@MainActivity, TransitionActivity0::class.java),
                    ActivityOptions.makeSceneTransitionAnimation(this@MainActivity).toBundle()
                )
            } else {
                startActivity(
                    Intent(this@MainActivity, TransitionActivity0::class.java)
                )
            }
        }
        transition1.setOnClickListener {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                var shareView = findViewById<View>(R.id.share_image)
                var share0 = Pair(shareView,"share_image")
                var options = ActivityOptionsCompat.makeSceneTransitionAnimation(this@MainActivity,share0)
                startActivity(
                    Intent(this@MainActivity, SharedElementTransitionActivity::class.java),
                    options.toBundle()
                )
            } else {
                startActivity(
                    Intent(this@MainActivity, SharedElementTransitionActivity::class.java)
                )
            }
        }
    }
}