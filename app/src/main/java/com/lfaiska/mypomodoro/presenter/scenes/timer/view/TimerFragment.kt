package com.lfaiska.mypomodoro.presenter.scenes.timer.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lfaiska.mypomodoro.R
import com.lfaiska.mypomodoro.databinding.TimerFragmentBinding

/**
 * Created by lucas on 30/03/18.
 */

class TimerFragment: Fragment() {
    private lateinit var binding: TimerFragmentBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.timer_fragment, container, false)
        return binding.root
    }
}