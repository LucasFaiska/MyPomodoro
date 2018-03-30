package com.lfaiska.mypomodoro.presenter.scenes.splash.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lfaiska.mypomodoro.MainApplication
import com.lfaiska.mypomodoro.R
import com.lfaiska.mypomodoro.presenter.scenes.splash.viewModel.SplashViewModel
import android.databinding.DataBindingUtil
import com.lfaiska.mypomodoro.databinding.SplashActivityBinding
import javax.inject.Inject

/**
 * Created by lucas on 30/03/18.
 */

class SplashActivity : AppCompatActivity(), SplashNavigation {

    @Inject
    lateinit var viewModel: SplashViewModel

    private lateinit var binding: SplashActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
        binding = DataBindingUtil.setContentView(this, R.layout.splash_activity)
        viewModel.navigation = this
        binding.viewModel = viewModel
    }

    override fun navigateToHome() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun injectDependencies() {
        MainApplication.appComponent.inject(this)
    }
}