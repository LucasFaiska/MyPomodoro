package com.lfaiska.mypomodoro.presenter.scenes.timer.pomodoro

/**
 * Created by lucas on 31/03/18.
 */

interface PomodoroCountDownTimerListener {
    fun onTick(timer: String)
    fun onFinish()
}