package com.lfaiska.mypomodoro.presenter.scenes.home.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.lfaiska.mypomodoro.R
import com.lfaiska.mypomodoro.databinding.HomeActivityBinding

/**
 * Created by lucas on 30/03/18.
 */

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.home_activity)
        supportActionBar?.let { it.elevation = 0F }
        setContentFragment(HomeFragment())
    }

    fun setContentFragment(fragment: Fragment) {
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        val supportFragmentManager = supportFragmentManager
        supportFragmentManager.beginTransaction()
                .replace(binding.homeFragmentContainer.id, fragment)
                .setTransition(FragmentTransaction.TRANSIT_NONE)
                .commit()
    }
}