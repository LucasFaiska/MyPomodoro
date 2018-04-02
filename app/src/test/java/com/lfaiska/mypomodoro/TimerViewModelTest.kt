package com.lfaiska.mypomodoro

import com.lfaiska.mypomodoro.domain.repository.PomodoroRepository
import com.lfaiska.mypomodoro.presenter.scenes.history.view.HistoryListener
import com.lfaiska.mypomodoro.presenter.scenes.timer.view.TimerInteraction
import com.lfaiska.mypomodoro.presenter.scenes.timer.viewmodel.TimerViewModel
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * Created by lucas on 01/04/18.
 */

class TimerViewModelTest {

    @Mock
    internal var historyListener: HistoryListener? = null
    @Mock
    internal var interaction: TimerInteraction? = null
    @Mock
    internal var repository: PomodoroRepository? = null

    lateinit var viewModel : TimerViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = Mockito.spy(TimerViewModel(repository!!))
        viewModel.interaction = interaction!!
        viewModel.historyListener = historyListener!!
    }

    @Test
    fun testToggleTimerState() {
        viewModel.isTimerRunning = true
        viewModel.toggleTimerState()
        Assert.assertEquals(viewModel.isTimerRunning, false)
        viewModel.toggleTimerState()
        Assert.assertEquals(viewModel.isTimerRunning, true)
    }

    @Test
    fun testToggleButtonIcon() {
        viewModel.isTimerRunning = true
        Assert.assertEquals(viewModel.toggleButtonIcon(), R.drawable.ic_stop)
        viewModel.isTimerRunning = false
        Assert.assertEquals(viewModel.toggleButtonIcon(), R.drawable.ic_play_arrow)
    }

    @Test
    fun testToggleTimerColor() {
        viewModel.isTimerRunning = true
        Assert.assertEquals(viewModel.toggleTimerColor(), R.color.colorPrimaryDark)
        viewModel.isTimerRunning = false
        Assert.assertEquals(viewModel.toggleTimerColor(), R.color.mediumGray)
    }

    @Test
    fun testButtonTouchedTimerIsRunning() {
        viewModel.isTimerRunning = true
        viewModel.onButtonTouched(null)
        verify(interaction)?.stopTimer()
    }

    @Test
    fun testButtonTouchedTimerIsStopped() {
        viewModel.isTimerRunning = false
        viewModel.onButtonTouched(null)
        verify(interaction)?.startTimer()
    }

    @Test
    fun testOnTimerFinished() {
        viewModel.onFinish()
        verify(interaction)?.showFinishAlertDialog()
    }
}