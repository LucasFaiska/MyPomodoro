package com.lfaiska.mypomodoro.presenter.scenes.timer.viewmodel

import android.databinding.ObservableInt
import android.view.View
import com.lfaiska.mypomodoro.R
import javax.inject.Inject

/**
 * Created by lucas on 31/03/18.
 */

class TimerViewModel @Inject constructor() {

    var isTimerRunning = false
    var buttonIcon = ObservableInt(R.drawable.ic_play_arrow)

    fun onButtonTouched(view: View) {
        toggleTimerState()
        buttonIcon.set(toggleButtonIcon())
    }

    private fun toggleTimerState() {
        isTimerRunning = !isTimerRunning
    }

    fun toggleButtonIcon(): Int {
        return if (isTimerRunning) R.drawable.ic_stop else R.drawable.ic_play_arrow
    }
}