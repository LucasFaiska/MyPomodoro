package com.lfaiska.mypomodoro.domain

import java.util.Date

/**
 * Created by lucas on 31/03/18.
 */

class Pomodoro (var runningTime: Long,
                var endTime: Date?,
                var status: Int) {

    companion object {
        var STATUS_FINISHED = 0
        var STATUS_FINISHED_LABEL = "Finished"
        var STATUS_STOPPED = 1
        var STATUS_STOPPED_LABEL = "Stopped"
    }
}