package com.lfaiska.mypomodoro.presenter.scenes.history.viewmodel

import com.lfaiska.mypomodoro.domain.repository.PomodoroRepository
import com.lfaiska.mypomodoro.presenter.scenes.history.list.HistorySectionAdapter
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * Created by lucas on 31/03/18.
 */

class HistoryViewModel @Inject constructor(var repository: PomodoroRepository) {

    fun getHistoryList(): List<HistorySectionAdapter>? {
        return repository.getHistory()?.let {
             it.groupBy { formatDate(it.endTime) }.map { HistorySectionAdapter( it.key, it.value) }
        }
    }

    fun formatDate(date: Date?): String {
        return SimpleDateFormat("dd/MM/yyyy").format(date)
    }
}