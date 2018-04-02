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
import com.lfaiska.mypomodoro.presenter.scenes.timer.view.TimerInteraction
import java.util.*
import javax.inject.Inject

/**
 * Created by lucas on 31/03/18.
 */

open class TimerViewModel @Inject constructor(var repository: PomodoroRepository) : PomodoroCountDownTimerListener {

    var isTimerRunning = false
    var buttonIcon = ObservableInt(R.drawable.ic_play_arrow)
    var timerColor = ObservableInt(R.color.mediumGray)
    var formattedTimer = ObservableField<String>()

    lateinit var historyListener: HistoryListener
    lateinit var interaction: TimerInteraction

    fun setup() {
        resetFormattedTimer()
    }

    fun onButtonTouched(view: View?) {
        toggleTimerState()
        toggleView()
        if (isTimerRunning) startPomodoro() else stopPomodoro()
    }

    fun toggleView() {
        buttonIcon.set(toggleButtonIcon())
        timerColor.set(toggleTimerColor())
    }

    fun toggleTimerState() {
        isTimerRunning = !isTimerRunning
    }

    fun startPomodoro() {
        interaction.startTimer()
    }

    fun stopPomodoro() {
        resetFormattedTimer()
        interaction.stopTimer()
        registerPomodoroHistory(Pomodoro.STATUS_STOPPED)
    }

    fun resetFormattedTimer() {
        formattedTimer.set(interaction.getFormattedInitialTimer())
    }

    fun toggleButtonIcon(): Int {
        return if (isTimerRunning) R.drawable.ic_stop else R.drawable.ic_play_arrow
    }

    fun toggleTimerColor(): Int {
        return if (isTimerRunning) R.color.colorPrimaryDark else R.color.mediumGray
    }

    fun registerPomodoroHistory(status: Int) {
        repository.save(Pomodoro(interaction.getTimerRunningTime(), Date(), status))
        historyListener?.let { it.onPomodoroRegister()  }
    }

    override fun onTick(timer: String) {
        formattedTimer.set(timer)
    }

    override fun onFinish() {
        interaction.showFinishAlertDialog()
        toggleTimerState()
        resetFormattedTimer()
        registerPomodoroHistory(Pomodoro.STATUS_FINISHED)
        toggleView()
    }
}