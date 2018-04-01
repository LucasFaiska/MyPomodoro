package com.lfaiska.mypomodoro.presenter.scenes.history.list

import android.databinding.DataBindingUtil
import android.text.TextUtils
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

    var items : List<HistorySectionAdapter> = emptyList()

    override fun onCreateHeaderViewHolder(parent: ViewGroup?, headerUserType: Int): HeaderViewHolder {
        val binding = DataBindingUtil.inflate<HistoryListHeaderBinding>(LayoutInflater.from(parent?.context), R.layout.history_list_header, parent, false)
        return HistoryListHeaderViewHolder(binding)
    }

    override fun onBindHeaderViewHolder(viewHolder: HeaderViewHolder?, sectionIndex: Int, headerUserType: Int) {
        (viewHolder as HistoryListHeaderViewHolder).setHeader(items.get(sectionIndex).header)
    }

    override fun onCreateItemViewHolder(parent: ViewGroup?, itemUserType: Int): ItemViewHolder {
        val binding = DataBindingUtil.inflate<HistoryListItemBinding>(LayoutInflater.from(parent?.context), R.layout.history_list_item, parent, false)
        return HistoryListItemViewHolder(binding)
    }

    override fun onBindItemViewHolder(viewHolder: ItemViewHolder?, sectionIndex: Int, itemIndex: Int, itemUserType: Int) {
        (viewHolder as HistoryListItemViewHolder).bind(HistoryListItemViewModel(items.get(sectionIndex).historyListItems[itemIndex]))
    }

    override fun getNumberOfSections(): Int {
        return items.size
    }

    override fun getNumberOfItemsInSection(sectionIndex: Int): Int {
        return items.get(sectionIndex).historyListItems.size
    }

    override fun doesSectionHaveHeader(sectionIndex: Int): Boolean {
        return !items.get(sectionIndex).historyListItems.isEmpty()
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