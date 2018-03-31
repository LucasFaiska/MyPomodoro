package com.lfaiska.mypomodoro.presenter.scenes.home.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lfaiska.mypomodoro.R
import com.lfaiska.mypomodoro.databinding.HomeFragmentBinding

/**
 * Created by lucas on 30/03/18.
 */

class HomeFragment: Fragment() {

    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        binding.homeViewPager.adapter = HomeAdapter(fragmentManager, context)
        binding.homeTabLayout.setupWithViewPager(binding.homeViewPager)
        return binding.root
    }
}