package com.example.recyclerexample

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.recycler_item.view.*
import android.view.animation.RotateAnimation
import android.view.animation.Animation

class RecyclerTitle(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val textView = itemView.textView
    private val imageView = itemView.imageView

    fun bindTitle(entity: MyEntity, listener: OnTitleSelected) {
        textView.text = entity.name
        itemView.rootView.setOnClickListener {
            switchArrow(entity)
            listener?.titleSelected(entity.nationality)
        }
    }

    private fun switchArrow(entity: MyEntity) {
        if (entity.showingChilds) {
            rotate180(imageView, true)
        } else {
            rotate180(imageView, false)
        }
        entity.showingChilds = !entity.showingChilds
    }

    private fun rotate180(view: View, reverse: Boolean) {
            view.setLayerType(View.LAYER_TYPE_HARDWARE, null)
            val rotateAnimation: RotateAnimation
            if (reverse) {
                rotateAnimation = RotateAnimation(
                    180f, 0f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f
                )
                view.rotation = 0f
            } else {
                rotateAnimation = RotateAnimation(
                    -1.0f * 180f, 0f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f
                )
                view.rotation = 180f
            }
            rotateAnimation.duration = 200
            rotateAnimation.fillAfter = true

            rotateAnimation.setAnimationListener(getAnimationListener(view))

            view.startAnimation(rotateAnimation)
    }

    private fun getAnimationListener(view: View): Animation.AnimationListener {
        return object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                // Nothing to do
            }

            override fun onAnimationEnd(animation: Animation) {
                view.setLayerType(View.LAYER_TYPE_NONE, null)
            }

            override fun onAnimationRepeat(animation: Animation) {
                // Nothing to do
            }
        }
    }
}