package com.example.transition

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.Scene
import androidx.transition.Transition
import androidx.transition.TransitionInflater
import androidx.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_transition_manager_go.*
import kotlinx.android.synthetic.main.source_scene.*

class TransitionManagerGoActivity : AppCompatActivity() {
    var  switch = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_manager_go)

        val sceneRoot: ViewGroup = findViewById(R.id.scene_root)
        val sourceScene = Scene.getSceneForLayout(sceneRoot, R.layout.source_scene, this)
        val targetScene = Scene.getSceneForLayout(sceneRoot, R.layout.target_scene, this)
        switch_sence.setOnClickListener {
            switch = !switch
            TransitionManager.go(if(switch) targetScene else sourceScene)
            targetScene.sceneRoot.findViewById<View>(R.id.image0).setOnClickListener{
                Toast.makeText(this@TransitionManagerGoActivity, "image0", Toast.LENGTH_SHORT).show()
            }
            targetScene.sceneRoot.findViewById<View>(R.id.image1).setOnClickListener{
                Toast.makeText(this@TransitionManagerGoActivity, "image1", Toast.LENGTH_SHORT).show()
            }
        }

        image0.setOnClickListener {
            Toast.makeText(this@TransitionManagerGoActivity, "image0", Toast.LENGTH_SHORT).show()
        }
        image1.setOnClickListener {
            Toast.makeText(this@TransitionManagerGoActivity, "image1", Toast.LENGTH_SHORT).show()
        }
    }
}