package com.lfaiska.mypomodoro.presenter.scenes.timer.viewmodel

import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.view.View
import com.lfaiska.mypomodoro.R
import com.lfaiska.mypomodoro.presenter.scenes.timer.pomodoro.PomodoroCountDownTimer
import com.lfaiska.mypomodoro.presenter.scenes.timer.pomodoro.PomodoroCountDownTimerListener
import javax.inject.Inject

/**
 * Created by lucas on 31/03/18.
 */

class TimerViewModel @Inject constructor() : PomodoroCountDownTimerListener {

    var isTimerRunning = false
    var buttonIcon = ObservableInt(R.drawable.ic_play_arrow)
    var timerColor = ObservableInt(R.color.mediumGray)
    var formattedTimer = ObservableField<String>()
    var timer = PomodoroCountDownTimer()

    init {
        timer.listener = this
        formattedTimer.set(timer.getFormattedInitialTimer())
    }

    fun onButtonTouched(view: View) {
        toggleTimerState()
    }

    private fun toggleTimerState() {
        if (isTimerRunning) {
            stopPomodoro()
        } else {
            startPomodoro()
        }

        isTimerRunning = !isTimerRunning
    }

    fun startPomodoro() {
        timer.start()
        buttonIcon.set(R.drawable.ic_stop)
        timerColor.set(R.color.colorPrimaryDark)
    }

    fun stopPomodoro() {
        formattedTimer.set(timer.getFormattedInitialTimer())
        timer.cancel()
        buttonIcon.set(R.drawable.ic_play_arrow)
        timerColor.set(R.color.mediumGray)
    }

    override fun onTick(timer: String) {
        formattedTimer.set(timer)
    }

    override fun onFinish() {

    }
}