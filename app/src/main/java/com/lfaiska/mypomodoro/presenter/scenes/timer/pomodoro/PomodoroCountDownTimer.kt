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
        var POMODORO_TIME = TimeUnit.MINUTES.toMillis(25)
        var TICK_TIME = TimeUnit.SECONDS.toMillis(1)
    }

    lateinit var listener: PomodoroCountDownTimerListener

    override fun onTick(p0: Long) {
        listener.onTick(getFormattedTimer(p0))
    }

    override fun onFinish() {
        listener.onFinish()
    }

    fun getFormattedInitialTimer(): String {
        return getFormattedTimer(POMODORO_TIME)
    }

    private fun getFormattedTimer(time: Long): String {
        val date = Date(time)
        val formatter = SimpleDateFormat("mm:ss")
        return formatter.format(date)
    }
}