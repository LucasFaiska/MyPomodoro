package com.lfaiska.mypomodoro.presenter.scenes.timer.pomodoro

import android.os.CountDownTimer
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by lucas on 31/03/18.
 */

class PomodoroCountDownTimer : CountDownTimer(POMODORO_TIME, TICK_TIME) {

    companion object {
        var POMODORO_TIME = TimeUnit.MINUTES.toMillis(1)
        var TICK_TIME = TimeUnit.SECONDS.toMillis(1)
    }

    lateinit var listener: PomodoroCountDownTimerListener
    var runningTime: Long = 0

    override fun onTick(p0: Long) {
        runningTime += TICK_TIME
        listener.onTick(getFormattedTimer(p0))
    }

    override fun onFinish() {
        runningTime = POMODORO_TIME
        listener.onFinish()
    }

    fun restartRunningTime() {
        runningTime = 0
    }

    fun getFormattedInitialTimer(): String {
        return getFormattedTimer(POMODORO_TIME)
    }

    private fun getFormattedTimer(time: Long): String {
        return SimpleDateFormat("mm:ss").format(Date(time))
    }
}