package com.lfaiska.mypomodoro.presenter.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by lucas on 31/03/18.
 */

class BindAdapters {

    companion object {
        @JvmStatic @BindingAdapter("android:src")
        fun setImageViewResource(imageView: ImageView, resource: Int) {
            imageView.setImageResource(resource)
        }

        @JvmStatic @BindingAdapter("android:textColor")
        fun setTextColor(textView:TextView, resource: Int) {
            textView.setTextColor(resource)
        }
    }
}