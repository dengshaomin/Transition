package com.example.transition

import android.annotation.SuppressLint
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.transition.*
import kotlinx.android.synthetic.main.activity_begin_delayed_transition.*

class BeginDelayedTransitionActivity : AppCompatActivity() {
    private var changeBoundsFlag = false
    private var changeTransformFlag = false
    private var changeClipBoundsFlag = false
    private var changeImageTransformFlag = false
    private var fadeFlag = false
    private var slideFlag = false
    private var explodeFlag = false
    private var pathFlag = false

    @SuppressLint("RtlHardcoded")
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_begin_delayed_transition)
        changeBounds.setOnClickListener {
            TransitionManager.beginDelayedTransition(changeBounds_root, ChangeBounds())
            changeBoundsFlag = !changeBoundsFlag
            var layoutParams = changeBounds_child.layoutParams as FrameLayout.LayoutParams
            var size = if (changeBoundsFlag) 200 else -200
            layoutParams.width += size
            layoutParams.height += size
            layoutParams.leftMargin += size
            changeBounds_child.layoutParams = layoutParams
        }

        changeTransform.setOnClickListener {
            var changeTransform = ChangeTransform()
//            changeTransform.duration = 2000
            TransitionManager.beginDelayedTransition(changeTransform_root, changeTransform)
            changeTransformFlag = !changeTransformFlag
            var size = if (changeTransformFlag) 200 else -200
            changeTransform_child.rotation += size
        }

        changeClipBounds.setOnClickListener {
            TransitionManager.beginDelayedTransition(changeClipBounds_root, ChangeClipBounds())
            changeClipBoundsFlag = !changeClipBoundsFlag
            changeClipBounds_child.clipBounds = if (changeClipBoundsFlag) Rect(
                0,
                0,
                changeClipBounds_child.right / 2,
                changeClipBounds_child.bottom / 2
            ) else null
        }

        changeImageTransform.setOnClickListener {
            TransitionManager.beginDelayedTransition(
                changeImageTransform_root,
                ChangeImageTransform()
            )
            changeImageTransformFlag = !changeImageTransformFlag
//            var layoutParams = changeImageTransform_child.layoutParams as FrameLayout.LayoutParams
//            var size = if (changeImageTransformFlag) 200 else -200
//            layoutParams.width += size
//            layoutParams.height += size
//            layoutParams.leftMargin += size
//            changeImageTransform_child.layoutParams = layoutParams
            changeImageTransform_child.scaleType =
                if (changeImageTransformFlag) ImageView.ScaleType.CENTER else ImageView.ScaleType.FIT_START
        }

        fade.setOnClickListener {
            TransitionManager.beginDelayedTransition(fade_root, Fade())
            fadeFlag = !fadeFlag
            fade_child.visibility = if (fadeFlag) View.INVISIBLE else View.VISIBLE
        }
        slide.setOnClickListener {
            var slide = Slide()
            slide.slideEdge = Gravity.RIGHT
            TransitionManager.beginDelayedTransition(slide_root, slide)
            slideFlag = !slideFlag
            slide_child.visibility = if (slideFlag) View.INVISIBLE else View.VISIBLE
        }
        explode.setOnClickListener {
            TransitionManager.beginDelayedTransition(explode_root, Explode())
            explodeFlag = !explodeFlag
            for (child in explode_root.children) {
                child.visibility = if (explodeFlag) View.INVISIBLE else View.VISIBLE
            }
        }
        path.setOnClickListener {
            var transition  = AutoTransition()
            transition.setPathMotion(ArcMotion())
            TransitionManager.beginDelayedTransition(path_root, transition)
            pathFlag = !pathFlag
            var layoutParams = path_child.layoutParams as FrameLayout.LayoutParams
            layoutParams.gravity = if(pathFlag) Gravity.RIGHT or  Gravity.BOTTOM else Gravity.LEFT or  Gravity.TOP
            path_child.layoutParams = layoutParams
        }

    }
}