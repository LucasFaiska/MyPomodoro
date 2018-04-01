package com.lfaiska.mypomodoro.presenter.scenes.home.view

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.ViewGroup
import com.lfaiska.mypomodoro.R
import com.lfaiska.mypomodoro.presenter.scenes.history.view.HistoryFragment
import com.lfaiska.mypomodoro.presenter.scenes.timer.view.TimerFragment

/**
 * Created by lucas on 30/03/18.
 */

class HomeAdapter(fm: FragmentManager, var context: Context) : FragmentPagerAdapter(fm) {

    var timerFragment = TimerFragment()
    var historyFragment  = HistoryFragment()

    init {
        timerFragment.historyListener = historyFragment
    }

    override fun getItem(position: Int): Fragment? = when (position) {
        0 -> timerFragment
        1 -> historyFragment
        else -> null
    }

    override fun getPageTitle(position: Int): CharSequence = when (position) {
        0 -> context.getString(R.string.toolbar_title_timer)
        1 -> context.getString(R.string.toolbar_title_history)
        else -> ""
    }

    override fun getCount(): Int = 2


}