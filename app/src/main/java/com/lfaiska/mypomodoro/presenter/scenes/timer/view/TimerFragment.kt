package com.lfaiska.mypomodoro.presenter.scenes.timer.view

import android.app.AlertDialog
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lfaiska.mypomodoro.MainApplication
import com.lfaiska.mypomodoro.R
import com.lfaiska.mypomodoro.databinding.TimerFragmentBinding
import com.lfaiska.mypomodoro.presenter.scenes.history.view.HistoryListener
import com.lfaiska.mypomodoro.presenter.scenes.timer.pomodoro.PomodoroCountDownTimer
import com.lfaiska.mypomodoro.presenter.scenes.timer.viewmodel.TimerViewModel
import javax.inject.Inject

/**
 * Created by lucas on 30/03/18.
 */

class TimerFragment : Fragment(), TimerInteraction {

    @Inject
    lateinit var viewModel: TimerViewModel

    private lateinit var binding: TimerFragmentBinding

    lateinit var historyListener: HistoryListener
    lateinit var alertDialog: AlertDialog.Builder

    var timer = PomodoroCountDownTimer()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        injectDependencies()
        binding = DataBindingUtil.inflate(inflater, R.layout.timer_fragment, container, false)
        timer.listener = viewModel
        binding.viewModel = viewModel
        setupViewModel()
        buildAlertDialog()
        return binding.root
    }

    fun setupViewModel() {
        viewModel.interaction = this
        viewModel.historyListener = historyListener
        viewModel.setup()
    }

    fun injectDependencies() {
        MainApplication.appComponent.inject(this)
    }

    fun buildAlertDialog() {
        alertDialog = AlertDialog.Builder(activity)
        alertDialog.setMessage(getString(R.string.alert_dialog_message))
    }

    override fun showFinishAlertDialog() {
        alertDialog.show()
    }

    override fun startTimer() {
        timer.restartRunningTime()
        timer.start()
    }

    override fun stopTimer() {
        timer.cancel()
    }

    override fun getTimerRunningTime(): Long {
        return timer.runningTime
    }

    override fun getFormattedInitialTimer(): String {
        return timer.getFormattedInitialTimer()
    }
}