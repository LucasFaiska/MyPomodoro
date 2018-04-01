package com.lfaiska.mypomodoro.domain.repository

import com.lfaiska.mypomodoro.domain.Pomodoro

/**
 * Created by lucas on 31/03/18.
 */

interface PomodoroRepository {
    fun getHistory() : List<Pomodoro>?
    fun save(pomodoro: Pomodoro)
}