package com.lfaiska.mypomodoro.presenter.scenes.timer.viewmodel

import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.view.View
import com.lfaiska.mypomodoro.R
import com.lfaiska.mypomodoro.domain.Pomodoro
import com.lfaiska.mypomodoro.domain.repository.PomodoroRepository
import com.lfaiska.mypomodoro.presenter.scenes.history.view.HistoryListener
import com.lfaiska.mypomodoro.presenter.scenes.timer.pomodoro.PomodoroCountDownTimer
import com.lfaiska.mypomodoro.presenter.scenes.timer.pomodoro.PomodoroCountDownTimerListener
import java.util.*
import javax.inject.Inject

/**
 * Created by lucas on 31/03/18.
 */

class TimerViewModel @Inject constructor(var repository: PomodoroRepository) : PomodoroCountDownTimerListener {

    var isTimerRunning = false
    var buttonIcon = ObservableInt(R.drawable.ic_play_arrow)
    var timerColor = ObservableInt(R.color.mediumGray)
    var formattedTimer = ObservableField<String>()
    var timer = PomodoroCountDownTimer()

    lateinit var historyListener: HistoryListener

    init {
        timer.listener = this
        resetFormattedTimer()
    }

    fun onButtonTouched(view: View) {
        toggleTimerState()
        toggleView()
        if (isTimerRunning) startPomodoro() else stopPomodoro()
    }

    private fun toggleView() {
        buttonIcon.set(toggleButtonIcon())
        timerColor.set(toggleTimerColor())
    }

    private fun toggleTimerState() {
        isTimerRunning = !isTimerRunning
    }

    fun startPomodoro() {
        timer.restartRunningTime()
        timer.start()
    }

    fun stopPomodoro() {
        resetFormattedTimer()
        timer.cancel()
        registerPomodoroHistory(Pomodoro.STATUS_STOPPED)
    }

    fun resetFormattedTimer() {
        formattedTimer.set(timer.getFormattedInitialTimer())
    }

    fun toggleButtonIcon(): Int {
        return if (isTimerRunning) R.drawable.ic_stop else R.drawable.ic_play_arrow
    }

    fun toggleTimerColor(): Int {
        return if (isTimerRunning) R.color.colorPrimaryDark else R.color.mediumGray
    }

    fun registerPomodoroHistory(status: Int) {
        repository.save(Pomodoro(timer.runningTime, Date(), status))
        historyListener?.let { it.onPomodoroRegister()  }
    }

    override fun onTick(timer: String) {
        formattedTimer.set(timer)
    }

    override fun onFinish() {
        toggleTimerState()
        resetFormattedTimer()
        registerPomodoroHistory(Pomodoro.STATUS_FINISHED)
        toggleView()
    }
}