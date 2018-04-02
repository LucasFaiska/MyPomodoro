package com.lfaiska.mypomodoro.presenter.scenes.timer.view

/**
 * Created by lucas on 01/04/18.
 */

interface TimerInteraction {
    fun showFinishAlertDialog()
    fun startTimer()
    fun stopTimer()
    fun getFormattedInitialTimer(): String
    fun getTimerRunningTime(): Long
}