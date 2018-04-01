package com.lfaiska.mypomodoro.presenter.scenes.history.list

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.lfaiska.mypomodoro.R
import com.lfaiska.mypomodoro.databinding.HistoryListHeaderBinding
import com.lfaiska.mypomodoro.databinding.HistoryListItemBinding
import org.zakariya.stickyheaders.SectioningAdapter

/**
 * Created by lucas on 01/04/18.
 */

class HistoryAdapter: SectioningAdapter() {

    var items : List<HistoryListItemViewModel> = emptyList()
    var headers : List<String> = emptyList()

    override fun onCreateHeaderViewHolder(parent: ViewGroup?, headerUserType: Int): HeaderViewHolder {
        val binding = DataBindingUtil.inflate<HistoryListHeaderBinding>(LayoutInflater.from(parent?.context), R.layout.history_list_header, parent, false)
        return HistoryListHeaderViewHolder(binding)
    }

    override fun onBindHeaderViewHolder(viewHolder: HeaderViewHolder?, sectionIndex: Int, headerUserType: Int) {
        (viewHolder as HistoryListHeaderViewHolder).setHeader(headers.get(sectionIndex))
    }

    override fun onCreateItemViewHolder(parent: ViewGroup?, itemUserType: Int): ItemViewHolder {
        val binding = DataBindingUtil.inflate<HistoryListItemBinding>(LayoutInflater.from(parent?.context), R.layout.history_list_item, parent, false)
        return HistoryListItemViewHolder(binding)
    }

    override fun onBindItemViewHolder(viewHolder: ItemViewHolder?, sectionIndex: Int, itemIndex: Int, itemUserType: Int) {
        (viewHolder as HistoryListItemViewHolder).bind(items.get(itemIndex))
    }
}

class HistoryListHeaderViewHolder(private var binding: HistoryListHeaderBinding) : SectioningAdapter.HeaderViewHolder(binding.root) {
    fun setHeader(headerTitle: String) {
        binding.historyHeaderTitle.text = headerTitle
    }
}

class HistoryListItemViewHolder(val binding: HistoryListItemBinding) : SectioningAdapter.ItemViewHolder(binding.root) {
    fun bind(viewModel: HistoryListItemViewModel): HistoryListItemBinding {
        binding.viewModel = viewModel
        return binding
    }
}