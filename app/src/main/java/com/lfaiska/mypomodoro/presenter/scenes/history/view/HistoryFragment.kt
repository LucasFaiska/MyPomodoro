package com.lfaiska.mypomodoro.presenter.scenes.history.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lfaiska.mypomodoro.MainApplication
import com.lfaiska.mypomodoro.R
import com.lfaiska.mypomodoro.databinding.HistoryFragmentBinding
import com.lfaiska.mypomodoro.presenter.scenes.history.viewmodel.HistoryViewModel
import javax.inject.Inject

/**
 * Created by lucas on 30/03/18.
 */

class HistoryFragment : Fragment() {

    @Inject
    lateinit var viewModel: HistoryViewModel

    private lateinit var binding: HistoryFragmentBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        injectDependencies()
        binding = DataBindingUtil.inflate(inflater, R.layout.history_fragment, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    fun injectDependencies() {
        MainApplication.appComponent.inject(this)
    }
}