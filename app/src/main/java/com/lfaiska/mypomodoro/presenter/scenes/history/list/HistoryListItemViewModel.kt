package com.lfaiska.mypomodoro.presenter.scenes.history.list

import com.lfaiska.mypomodoro.domain.Pomodoro
import java.text.SimpleDateFormat

/**
 * Created by lucas on 01/04/18.
 */

class HistoryListItemViewModel(var pomodoro: Pomodoro) {

    fun getFormattedRunningTime(): String {
        return SimpleDateFormat("mm:ss").format(pomodoro.runningTime)
    }

    fun getFormattedEndTime(): String {
        return SimpleDateFormat("hh a").format(pomodoro.endTime)
    }

    fun getStatus(): String {
        with(Pomodoro) {
            return if (pomodoro.status == STATUS_STOPPED) STATUS_STOPPED_LABEL else STATUS_FINISHED_LABEL
        }
    }
}