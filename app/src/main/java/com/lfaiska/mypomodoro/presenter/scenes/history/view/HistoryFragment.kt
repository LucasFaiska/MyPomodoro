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
import com.lfaiska.mypomodoro.presenter.scenes.history.list.HistoryAdapter
import com.lfaiska.mypomodoro.presenter.scenes.history.viewmodel.HistoryViewModel
import kotlinx.android.synthetic.main.history_fragment.view.*
import org.zakariya.stickyheaders.StickyHeaderLayoutManager
import javax.inject.Inject

/**
 * Created by lucas on 30/03/18.
 */

class HistoryFragment : Fragment(), HistoryListener {

    @Inject
    lateinit var viewModel: HistoryViewModel

    var adapter = HistoryAdapter()
    private lateinit var binding: HistoryFragmentBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        injectDependencies()
        binding = DataBindingUtil.inflate(inflater, R.layout.history_fragment, container, false)
        binding.viewModel = viewModel
        binding.historyRecyclerView.layoutManager = StickyHeaderLayoutManager()
        binding.historyRecyclerView.adapter = adapter
        return binding.root
    }

    override fun onResume() {
        updateHistoryAdapter()
        super.onResume()
    }

    fun injectDependencies() {
        MainApplication.appComponent.inject(this)
    }

    fun updateHistoryAdapter() {
        adapter.items = viewModel.getHistoryList()!!
        adapter.notifyAllSectionsDataSetChanged()
    }

    override fun onPomodoroRegister() {
        updateHistoryAdapter()
    }
}